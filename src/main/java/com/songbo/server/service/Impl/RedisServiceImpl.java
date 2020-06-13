package com.songbo.server.service.Impl;

import com.songbo.server.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName RedisServiceImpl
 * @Description TODO
 * @Author songbo
 * @Date 19-10-10 下午4:17
 **/
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean setValue(String key, Object object) {
        try {
            redisTemplate.opsForValue().set(key, object);
            log.warn("redis存储key："+key);
            return true;
        } catch (Exception e){
            log.warn("redis存储key失败："+key);
            return false;
        }
    }

    @Override
    public <T> T getValue(String key, Class<T> tClass) {
        if (redisTemplate.hasKey(key)){
            try {
                T t = (T) redisTemplate.opsForValue().get(key);
                log.warn("get redis value "+key);
                return t;
            } catch (Exception e){
                log.warn("redis序列化失败! key:"+key+" type: "+tClass);
                return null;
            }
        } else {
            log.warn("key不存在!"+key);
            return null;
        }
    }

    @Override
    public <T> Map<String, T> getMapValue(String hk, String k, Class<T> tClass) {
        return null;
    }
}
