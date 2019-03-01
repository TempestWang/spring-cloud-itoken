package com.funtl.itoken.service.redis.service;

/**
 * User: Swang
 * Date: 2019-01-27
 * Time: 16:00
 */
public interface RedisService {

    /**
     *
     * @param key
     * @param value
     * @param seconds 超时时间
     */
    public void put(String key, Object value, long seconds);

    public Object get(String key);
}
