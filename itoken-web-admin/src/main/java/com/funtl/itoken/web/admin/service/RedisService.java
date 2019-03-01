package com.funtl.itoken.web.admin.service;

import com.funtl.itoken.web.admin.service.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: Swang
 * Date: 2019-01-29
 * Time: 11:28
 */
@FeignClient(value = "itoken-service-redis", fallback = RedisServiceFallback.class)
public interface RedisService {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(@RequestParam("key") String key);

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(
            @RequestParam("key") String key,
            @RequestParam("value") Object value,
            @RequestParam("seconds") long seconds);
}
