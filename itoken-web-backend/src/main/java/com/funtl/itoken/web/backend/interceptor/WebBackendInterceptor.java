package com.funtl.itoken.web.backend.interceptor;

import com.funtl.itoken.common.domain.TbSysUser;
import com.funtl.itoken.common.utils.CookieUtils;
import com.funtl.itoken.common.utils.MapperUtils;
import com.funtl.itoken.common.web.constants.WebConstants;
import com.funtl.itoken.common.web.utils.HttpServletUtils;
import com.funtl.itoken.web.backend.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * User: Swang
 * Date: 2019-01-29
 * Time: 11:03
 */
public class WebBackendInterceptor implements HandlerInterceptor{

    @Autowired
    private RedisService redisService;

    @Value(value = "${hosts.sso}")
    private String hosts_sso;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);

        //token为空表示一定没有登录
        if (StringUtils.isBlank(token)) {
            try {
//                response.sendRedirect("http://localhost:8503/login?url=http://localhost:8602");
                response.sendRedirect(String.format("%s/login?url=%s", hosts_sso, HttpServletUtils.getFullPath(request)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        HttpSession session = request.getSession();
        TbSysUser tbSysUser = (TbSysUser) session.getAttribute(WebConstants.SESSION_USER);

        //已登录状态
        if (tbSysUser != null) {
            if (modelAndView != null) {
                modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
            }
        //未登录状态
        } else {
            String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
            if (StringUtils.isNotBlank(token)) {
                String loginCode = redisService.get(token);
                if (StringUtils.isNotBlank(loginCode)) {
                    String json = redisService.get(loginCode);
                    if (StringUtils.isNotBlank(json)) {
                        try {
                            //已登录状态,创建局部会话
                            tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                            if (modelAndView != null) {
                                modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
                            }
                            request.getSession().setAttribute(WebConstants.SESSION_USER, tbSysUser);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
        //二次确认是否有用户信息
        if (tbSysUser == null) {
            try {
                response.sendRedirect(String.format("%s/login?url=%s", hosts_sso, HttpServletUtils.getFullPath(request)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
