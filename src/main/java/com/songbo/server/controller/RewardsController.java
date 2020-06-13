package com.songbo.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.rewards.RewardsaddfundingResult;
import com.songbo.server.bean.sendTransaction.RPCResponseForT;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.service.RewardsService;
import com.songbo.server.service.TransactionService;
import com.songbo.server.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RewardsController
 * @Description TODO
 * @Author songbo
 * @Date 19-10-22 上午9:55
 **/
@RestController
@RequestMapping("/rewards")
@Slf4j
public class RewardsController {
    @Autowired
    private RewardsService rewardsService;
    @Autowired
    private RPCRequestService rpcRequestService;
    @Autowired
    private TransactionService transactionService;

    /**
      *@Description TODO
      *@param //String name, String fundingtxid, String amount
      *@return
    **/
    @PostMapping("/rewardsaddfunding")
    public ResultUtil addfunding(@RequestBody JSONObject jsonObject){
        String name = jsonObject.getString("name");
        String fundingtxid = jsonObject.getString("fundingtxid");
        String amount = jsonObject.getString("amount");

        try {
            RewardsaddfundingResult addfunding = rewardsService.addfunding(name, fundingtxid, amount);
            if (addfunding != null){
                RPCResponseForT<String, String> rpcResponseForT1 = rpcRequestService.rpcRequest(transactionService.sendTransaction(addfunding.getHex()), RPCResponseForT.class);
                if (rpcResponseForT1.getError() == null){
                    return ResultUtil.result200("success!",rpcResponseForT1.getResult());
                }else {
                    log.error("createFunding_sendtransaction: "+rpcResponseForT1.getError());
                    return ResultUtil.result500("服务器错误！",rpcResponseForT1.getError());
                }
            } else {
                return ResultUtil.result400("参数错误！","");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.result500("服务器错误！",e);
        }
    }
}
