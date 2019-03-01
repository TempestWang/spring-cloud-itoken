package com.funtl.itoken.service.sso.service;

import com.funtl.itoken.common.domain.TbSysUser;

/**
 * User: Swang
 * Date: 2019-01-28
 * Time: 10:18
 */
public interface LoginService {

    /**
     * 登录
     * @param loginCode
     * @param plantPassword
     * @return
     */
    public TbSysUser login(String loginCode, String plantPassword);
}
