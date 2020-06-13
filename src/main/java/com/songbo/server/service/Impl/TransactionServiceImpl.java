package com.songbo.server.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.Utxo;
import com.songbo.server.service.ExplorerService;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.service.TransactionService;
import com.songbo.server.utils.NumberUtil;
import com.songbo.server.utils.RPCRequestParams;
import com.songbo.server.utils.RPCRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.spi.NumberFormatProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TransactionServiceImpl
 * @Description TODO
 * [
 *  [
 *      {
 *          "txid":"1fab5888cfb00b4123ef4e44f55ae230ee24382ebefcbff8e565cb16e6354156",
 *          "vout":1
 *      },
 *      {
 *          "txid":"d965a36c71abc5c02a117c602afa88f499c7b66e40964bb441f58b600aec1964",
 *          "vout":1
 *      }
 *  ],
 *  {
 *  "RGd77ChrgHVNgYU4ptXaofCCBYnkho1xJr":8,
 *  "RWAcLSVK742UVvStNVZEVFaV8gDFjrxGJt":1.9994
 *  }
 * ]
 * @Author songbo
 * @Date 19-9-26 下午2:07
 **/
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private RPCRequestService rpcRequestService;
    @Autowired
    private ExplorerService explorerService;

    @Override
    public synchronized JSONObject createTransaction(List<Utxo> utxos, String from, String to, double cost){


        List<Map<String, Object>> mapList = new ArrayList<>();
        double num = 0;
        //找到可以符合转账要求的utxo list
        for (Utxo utxo : utxos){
            num += utxo.getAmount();
            if (num<=cost){
                Map<String, Object> utxosMap = new HashMap<>();
                utxosMap.put("txid", utxo.getTxid());
                utxosMap.put("vout", utxo.getVout());
                mapList.add(utxosMap);
            }else {
                Map<String, Object> utxosMap = new HashMap<>();
                utxosMap.put("txid", utxo.getTxid());
                utxosMap.put("vout", utxo.getVout());
                mapList.add(utxosMap);
                if (utxo.getAmount()>cost){
                    mapList.clear();
                    num = utxo.getAmount();
                    mapList.add(utxosMap);
                }
                break;
            }
        }

        double rest = num - cost - RPCRequestParams.DIC_FEE;

        Map<String, Object> costmap = new HashMap<>();
        costmap.put(to, cost);
        costmap.put(from, NumberUtil.formatDouble(rest));

        return RPCRequestUtil.RPCRequest2(RPCRequestParams.CREATETRANSACTION,mapList,costmap);
    }

    @Override
    public JSONObject signTransaction(String hex) {
        return RPCRequestUtil.RPCRequest1(RPCRequestParams.SIGNRAWTRANSACTION,hex);
    }

    @Override
    public JSONObject sendTransaction(String hex) {
        return RPCRequestUtil.RPCRequest1(RPCRequestParams.SENDRAWTRANSACTION,hex);
    }
}
