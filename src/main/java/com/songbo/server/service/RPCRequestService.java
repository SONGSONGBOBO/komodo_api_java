package com.songbo.server.service;

import com.alibaba.fastjson.JSONObject;

import com.songbo.server.bean.RPCResponse;
import com.songbo.server.bean.RPCResponseForS;
import com.songbo.server.bean.sendTransaction.RPCResponseForT;
import com.songbo.server.bean.token.TokenCreateResult;
import com.songbo.server.bean.token.TokenListResult;

/**
 * @ClassName RPCRequestService
 * @Description TODO
 * @Author songbo
 * @Date 19-9-21 下午1:58
 **/

public interface RPCRequestService {
    /**
     *@Description TODO 重写成泛型 下面的都不用了 但是不能解决泛型嵌套问题（会返回jsonobject）
     *@param
     *@return
     **/
    <T> T rpcRequest(JSONObject params, Class<T> tClass);
    /**
     *@Description TODO 嵌套泛型RPCResponseForT fastjson不能很好的序列化，采用泛型中的构造方法，再分别序列化T和V
     *@param
     *@return
     **/
    <T,V> RPCResponseForT<T, V> rpcRequestForRPCResponseForT(JSONObject params, Class<T> tClass,Class<V> vClass);
    /**
      *@Description TODO get
      *@param
      *@return
    **/
    String rpcGetRequest(String url);
    /**
     *@Description TODO get
     *@param
     *@return
     **/
    String rpcGetRequestRest(String url);
    /**
      *@Description TODO create transaction
      *@param
      *@return
    **/
    RPCResponse transactionRequest(JSONObject params);
    /**
      *@Description TODO 一个参数
      *@param
      *@return
    **/
    RPCResponseForS StringTransactionRequest(JSONObject params);
    /**
      *@Description TODO token list
      *@param
      *@return
    **/
    TokenListResult rpcTokenListRequest(JSONObject params);
    /**
      *@Description TODO
      *@param
      *@return
    **/
    TokenCreateResult rpcTokenCreateRequest(JSONObject params);

}
