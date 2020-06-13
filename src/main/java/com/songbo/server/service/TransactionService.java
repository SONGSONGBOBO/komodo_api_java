package com.songbo.server.service;

import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.Utxo;

import java.util.List;

public interface TransactionService {

    /**
      *@Description TODO 构建transaction
     *@return
    *
     * @param*/
    JSONObject createTransaction(List<Utxo> utxos, String from, String to, double cost);
     /**
       *@Description TODO 签名transaction
       *@param
       *@return
     **/
     JSONObject signTransaction(String hex);
     /**
       *@Description TODO 发送transaction
       *@param
       *@return
     **/
     JSONObject sendTransaction(String hex);


}
