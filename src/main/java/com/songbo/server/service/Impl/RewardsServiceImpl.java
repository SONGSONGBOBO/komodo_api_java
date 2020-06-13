package com.songbo.server.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.rewards.*;
import com.songbo.server.bean.sendTransaction.RPCResponseForSend;
import com.songbo.server.bean.sendTransaction.RPCResponseForT;
import com.songbo.server.mapper.RewardsMapper;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.service.RewardsService;
import com.songbo.server.service.TransactionService;
import com.songbo.server.utils.RPCRequestParams;
import com.songbo.server.utils.RPCRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RewardsServiceImpl
 * @Description TODO
 * @Author songbo
 * @Date 19-10-22 上午10:06
 **/
@Service
@Slf4j
public class RewardsServiceImpl implements RewardsService {
    @Autowired
    private RPCRequestService rpcRequestService;
    @Autowired
    private TransactionService transactionService;


    @Override
    public RewardsaddfundingResult addfunding(String name, String fundingtxid, String amount) {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest3(RPCRequestParams.REWARDSADDFUNDING, name, fundingtxid, amount);
        RPCResponseForT<RewardsaddfundingResult, String> rpcResponseForT = rpcRequestService.rpcRequestForRPCResponseForT(jsonObject, RewardsaddfundingResult.class, String.class);
        if (rpcResponseForT.getError()==null){
            log.warn("rewardsaddfunding: "+name+" "+amount);
           /* String s = rpcResponseForT.toString();
            RPCResponseForT<RewardsaddfundingResult, String> rewardsaddfundingResult = JSONObject.toJavaObject((JSON) JSON.parse(s), RPCResponseForT.class);*/
            return rpcResponseForT.getResult();
        } else {
            log.error("rewardsaddfunding_fail"+name+" "+amount);
            return null;
        }
    }

    @Override
    public RewardsaddressResult rewardsaddress(String pubkey) {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest1(RPCRequestParams.REWARDSADDRESS, pubkey);
        RPCResponseForT<RewardsaddressResult, String> rpcResponseForT = rpcRequestService.rpcRequest(jsonObject, RPCResponseForT.class);
        if (rpcResponseForT.getError()==null){
            log.warn("rewardsaddfunding: "+pubkey);
            return rpcResponseForT.getResult();
        } else {
            log.error("rewardsaddfunding_fail"+pubkey);
            return null;
        }

    }

    @Override
    public RewardscreatefundingResult createFunding(String name, String amount, String rate, String mindays, String maxdays, String minmoney) {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest6(RPCRequestParams.CREATEFUNDING, name, amount, rate, mindays, maxdays, minmoney);
        //RewardscreatefundingResult rewardscreatefundingResult = rpcRequestService.rpcRequest(jsonObject, RewardscreatefundingResult.class);
        RPCResponseForT<RewardscreatefundingResult, String> rpcResponseForT = rpcRequestService.rpcRequest(jsonObject, RPCResponseForT.class);
        /*RPCResponseForT<String, String> rpcResponseForT1 = rpcRequestService.rpcRequest(transactionService.sendTransaction(rpcResponseForT.getResult().getHex()), RPCResponseForT.class);
        if (rpcResponseForT1.getError() == null){
            return rpcResponseForT1.getResult();
        }else {
            log.error("createFunding: "+rpcResponseForT1.getError());
            return null;
        }*/
        if (rpcResponseForT.getError()==null){
            log.warn("rewardsaddfunding: "+name+" "+amount);
            return rpcResponseForT.getResult();
        } else {
            log.error("rewardsaddfunding_fail"+name+" "+amount);
            return null;
        }

    }

    @Override
    public RewardsinfoResult rewardsinfo(String fundingtxid) {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest1(RPCRequestParams.REWARDSINFO, fundingtxid);
        RPCResponseForT<RewardsinfoResult, String> rpcResponseForT = rpcRequestService.rpcRequest(jsonObject, RPCResponseForT.class);
        if (rpcResponseForT.getError()==null){
            log.warn("rewardsinfo: "+fundingtxid);
            return rpcResponseForT.getResult();
        } else {
            log.error("rewardsinfo_fail"+fundingtxid);
            return null;
        }
    }

    @Override
    public RewardslistResult rewardslist() {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest0(RPCRequestParams.REWARDSLIST);
        RPCResponseForT<RewardslistResult, String> rpcResponseForT = rpcRequestService.rpcRequest(jsonObject, RPCResponseForT.class);
        if (rpcResponseForT.getError()==null){
            log.warn("rewardslist: ");
            return rpcResponseForT.getResult();
        } else {
            log.error("rewardslist_fail");
            return null;
        }
    }

    @Override
    public RewardslockResult rewardslock(String name, String fundingtxid, String amount) {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest3(RPCRequestParams.REWARDSLOCK, name, fundingtxid, amount);
        RPCResponseForT<RewardslockResult, String> rpcResponseForT = rpcRequestService.rpcRequest(jsonObject, RPCResponseForT.class);
        if (rpcResponseForT.getError()==null){
            log.warn("rewardslock: "+name+" "+amount);
            return rpcResponseForT.getResult();
        } else {
            log.error("rewardslock_fail"+name+" "+amount);
            return null;
        }
    }

    @Override
    public RewardsunlockResult rewardsunlock(String name, String fundingtxid, String txid) {
        JSONObject jsonObject = RPCRequestUtil.RPCRequest3(RPCRequestParams.REWARDSUNLOCK, name, fundingtxid, txid);
        RPCResponseForT<RewardsunlockResult, String> rpcResponseForT = rpcRequestService.rpcRequest(jsonObject, RPCResponseForT.class);
        if (rpcResponseForT.getError()==null){
            log.warn("rewardsunlock: "+name+" "+txid);
            return rpcResponseForT.getResult();
        } else {
            log.error("rewardsunlock_fail"+name+" "+txid);
            return null;
        }
    }
}
