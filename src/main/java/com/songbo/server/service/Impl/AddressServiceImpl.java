package com.songbo.server.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.address.CreateAddressResult;
import com.songbo.server.service.AddressService;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.utils.RPCRequestParams;
import com.songbo.server.utils.RPCRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName addressServiceImpl
 * @Description TODO
 * @Author songbo
 * @Date 19-9-19 下午2:11
 **/
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private RPCRequestService rpcRequestService;

    @Override
    public String createNewAdress() {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest0(RPCRequestParams.CREATE_ADDRESS);
        CreateAddressResult createAddressResult = rpcRequestService.rpcRequest(jsonObject, CreateAddressResult.class);
        if (createAddressResult != null && createAddressResult.getError()==null){
            return createAddressResult.getResult();
        } else {
            log.error("创建地址失败： "+createAddressResult.toString());
            return null;
        }

    }

    @Override
    public String getAddresses() {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest1(RPCRequestParams.getaddresses,"");
        CreateAddressResult createAddressResult = rpcRequestService.rpcRequest(jsonObject, CreateAddressResult.class);
        if (createAddressResult != null && createAddressResult.getError()==null){
            return createAddressResult.getResult();
        } else {
            log.error("创建地址失败： "+createAddressResult.toString());
            return null;
        }

    }
}
