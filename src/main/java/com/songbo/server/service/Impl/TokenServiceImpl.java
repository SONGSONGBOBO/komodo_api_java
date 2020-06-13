package com.songbo.server.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.RPCResponse;
import com.songbo.server.bean.RPCResponseForS;
import com.songbo.server.bean.token.TokenCreateResult;
import com.songbo.server.bean.token.TokenListResult;
import com.songbo.server.entity.Token;
import com.songbo.server.mapper.TokenMapper;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.service.TokenService;
import com.songbo.server.utils.RPCRequestParams;
import com.songbo.server.utils.RPCRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TokenServiceImpl
 * @Description TODO
 * @Author songbo
 * @Date 19-10-5 下午3:26
 **/
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RPCRequestService rpcRequestService;
    @Resource
    private TokenMapper tokenMapper;
    @Override
    public RPCResponse createToken(String name, String num, String msg) {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest3("tokencreate",name,num,msg);
        TokenCreateResult tokenCreateResult = rpcRequestService.rpcRequest(jsonObject, TokenCreateResult.class);
        String hex = tokenCreateResult.getResult().getHex();
        JSONObject jsonObject1 = RPCRequestUtil.RPCRequest1(RPCRequestParams.SENDRAWTRANSACTION, hex);
        RPCResponse rpcResponse = rpcRequestService.rpcRequest(jsonObject1, RPCResponse.class);
        log.warn("create token: "+jsonObject.toString());
        return  rpcResponse;
    }

    @Override
    public List<Token> getTokenList() {
        /*JSONObject jsonObject = RPCRequestUtil.RPCRequest0("tokenlist");
        //{"result":["4319341d5a7149c50138f58a37042e50a8026e592ded7876f6e2d52e68d7a22d"],"error":null,"id":"test01"}
        TokenListResult tokenListResult = rpcRequestService.rpcTokenListRequest(jsonObject);
        List<String> stringList = tokenListResult.getResult();*/
        return tokenMapper.getTokenList();
    }

    @Override
    public Token getTokenById(int id) {
        return tokenMapper.getTokenById(id);
    }
}
