package com.songbo.server.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.songbo.server.bean.Utxo;
import com.songbo.server.service.ExplorerService;
import com.songbo.server.service.RPCRequestService;
import com.songbo.server.utils.RPCRequestParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExplorerServiceImpl
 * @Description TODO
 * @Author songbo
 * @Date 19-9-21 下午12:41
 **/
@Slf4j
@Service
public class ExplorerServiceImpl implements ExplorerService {
    @Autowired
    private RPCRequestService rpcRequestService;

    @Override
    public String getBalance(String addr) {
        return rpcRequestService.rpcGetRequest(addr);
    }

    @Override
    public String getTxs(String from, String to, String addr) {
        String url = RPCRequestParams.EXPLORER_URL_addrs+addr+RPCRequestParams.EXPLORER_URL_txs+"from="+from+"&to="+to;
        log.warn("txs_url: "+url);
        return rpcRequestService.rpcGetRequest(url);
    }

    @Override
    public List<Utxo> getUtxos(String addr) {
        String url = RPCRequestParams.EXPLORER_URL_addrs+addr+RPCRequestParams.EXPLORER_URL_utxo;
        log.warn("utxos_url: "+url);
        String s = rpcRequestService.rpcGetRequest(url);
        JSONArray s1 = (JSONArray) JSONArray.parse(s);
        List<Utxo> utxos = s1.toJavaList(Utxo.class);
        log.warn("getutxos: ",s);
        return utxos;
    }
}
