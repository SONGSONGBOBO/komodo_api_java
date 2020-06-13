package com.songbo.server.service;

import org.springframework.stereotype.Service;


public interface AddressService {
    /**
      *@Description TODO 创建新的地址
      *@param
      *@return
    **/
    String  createNewAdress();

    String getAddresses();
}
