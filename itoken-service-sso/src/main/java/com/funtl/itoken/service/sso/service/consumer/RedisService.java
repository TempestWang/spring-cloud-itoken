package com.funtl.itoken.service.sso.service.consumer;

import com.funtl.itoken.service.sso.service.consumer.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * User: Swang
 * Date: 2019-01-28
 * Time: 10:25
 */
@FeignClient(value = "itoken-service-redis", fallback = RedisServiceFallback.class)
public interface RedisService {

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public String put(@RequestParam(value = "key") String key, @RequestParam(value = "value") Object value, @RequestParam(value = "seconds") long seconds);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(@RequestParam(value = "key") String key);
}
