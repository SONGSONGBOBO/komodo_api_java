package com.songbo.server.service;

import com.songbo.server.bean.RPCResponse;
import com.songbo.server.entity.Token;

import java.util.List;

public interface TokenService {
    /**
      *@Description TODO
     * "method": "tokencreate", "params":  ["Tak","10","Test"] }'
     *@return
    *
     * @param*/
    RPCResponse createToken(String name, String num, String msg);
    /**
      *@Description TODO
      *@param
      *@return
    **/
    List<Token> getTokenList();
    /**
      *@Description TODO
      *@param
      *@return
    **/
    Token getTokenById(int id);
    /**
      *@Description TODO
      *@param
      *@return
    **/

}
