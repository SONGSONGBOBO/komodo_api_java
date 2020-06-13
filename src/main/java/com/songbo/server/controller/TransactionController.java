package com.songbo.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.RPCResponse;
import com.songbo.server.bean.RPCResponseForS;
import com.songbo.server.bean.Utxo;
import com.songbo.server.bean.sendTransaction.RPCResponseForSend;
import com.songbo.server.service.ExplorerService;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.service.TransactionService;
import com.songbo.server.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TransactionController
 * @Description TODO
 * @Author songbo
 * @Date 19-9-19 下午2:17
 **/
@RestController
@RequestMapping("/transaction")
@Slf4j
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private RPCRequestService rpcRequestService;
    @Autowired
    private ExplorerService explorerService;

    @PostMapping("/sendTRansaction")
    public ResultUtil makeTransaction(@RequestBody JSONObject jsonObject){
        String from = jsonObject.getString("from");
        String to = jsonObject.getString("to");
        double cost = jsonObject.getDouble("cost");
        try {
            List<Utxo> utxos = explorerService.getUtxos(from);
            JSONObject jsonObject1 = transactionService.createTransaction(utxos,from,to,cost);
            RPCResponse rpcResponse = rpcRequestService.transactionRequest(jsonObject1);
            if (rpcResponse.getError() == null){
                RPCResponseForS rpcResponseForSign = rpcRequestService.rpcRequest(transactionService.signTransaction(rpcResponse.getResult()), RPCResponseForS.class);
                if (rpcResponseForSign.getResult().getComplete()){
                    RPCResponseForSend rpcResponseForSend = rpcRequestService.rpcRequest(transactionService.sendTransaction(rpcResponseForSign.getResult().getHex()), RPCResponseForSend.class);
                    if (rpcResponseForSend.getResult() != null){
                        return ResultUtil.result200("transaction",rpcResponseForSend);
                    }
                    return ResultUtil.result400(" send transaction err",rpcResponseForSend);
                }
                return ResultUtil.result400("sign transaction err",rpcResponseForSign);
            }
            return ResultUtil.result400("create transaction err",rpcResponse);
        } catch (Exception e){
            log.error("err: "+e,e);
            return ResultUtil.result500("请求服务器失败",e);
        }
        
    }
}
