package com.funtl.itoken.common.web.service;

import com.funtl.itoken.common.hystrix.Fallback;

/**
 * User: Swang
 * Date: 2019-02-10
 * Time: 14:18
 */
public interface BaseClientService {
    default String page(int pageNum, int pageSize, String domainJson) {
        return Fallback.badGateway();
    }
}
