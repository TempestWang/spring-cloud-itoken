package com.funtl.itoken.service.sso.service.consumer.fallback;

import com.funtl.itoken.service.sso.service.consumer.RedisService;
import org.springframework.stereotype.Component;

/**
 * User: Swang
 * Date: 2019-01-28
 * Time: 10:32
 */
@Component
public class RedisServiceFallback implements RedisService {

    @Override
    public String put(String key, Object value, long seconds) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }
}
