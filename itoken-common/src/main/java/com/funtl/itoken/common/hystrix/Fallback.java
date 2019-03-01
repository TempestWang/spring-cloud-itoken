package com.funtl.itoken.common.hystrix;

import com.funtl.itoken.common.constans.HttpStatusConstants;
import com.funtl.itoken.common.dto.BaseResult;
import com.funtl.itoken.common.utils.MapperUtils;
import com.google.common.collect.Lists;

/**
 * 通用的熔断方法
 * User: Swang
 * Date: 2019-01-28
 * Time: 10:36
 */
public class Fallback {

    /**
     * 502错误
     * @return
     */
    public static String badGateway() {
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                        HttpStatusConstants.BAD_GATEWAY.getContent())));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
