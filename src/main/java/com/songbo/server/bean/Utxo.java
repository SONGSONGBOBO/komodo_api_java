package com.songbo.server.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Utxo
 * @Description TODO utxo
 * @Author songbo
 * @Date 19-9-25 下午7:25
 **/
@Getter
@Setter
@ToString
public class Utxo {

    private String address;
    private String txid;
    private int vout;
    private String scriptPubKey;
    private double amount;
    private long satoshis;
    private long height;
    private long confirmations;

}
