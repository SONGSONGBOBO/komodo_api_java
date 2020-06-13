package com.songbo.server.service;


import java.util.Map;

public interface RedisService {
    /**
      *@Description TODO set value
      *@param
      *@return
    **/
    boolean setValue(String key, Object object);
    /**
      *@Description TODO 获取value
      *@param
      *@return
    **/
   <T> T getValue(String key, Class<T> tClass);
   /**
     *@Description TODO 获取hash value
     *@param
     *@return
   **/
   <T> Map<String, T> getMapValue(String hk, String k, Class<T> tClass);
}
