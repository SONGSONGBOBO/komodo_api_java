package com.songbo.server.service;


import com.songbo.server.bean.Utxo;

import java.util.List;

/**
 * @ClassName ExplorerService
 * @Description TODO
 * @Author songbo
 * @Date 19-9-21 下午12:39
 **/

public interface ExplorerService {

    String getBalance(String addr);
    /**
      *@Description TODO transaction history
      *@param
      *@return
    **/
    String getTxs(String from, String to, String addr);
    /**
      *@Description TODO get useful utxos
     *@return
    *
     * @param*/
    List<Utxo> getUtxos(String addr);
}
