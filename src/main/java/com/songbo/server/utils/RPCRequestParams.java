package com.songbo.server.utils;

/**
 * @ClassName RPCRequestParams
 * @Description TODO
 * @Author songbo
 * @Date 19-9-19 下午2:13
 **/
public class RPCRequestParams {

    


    public final static String CREATE_ADDRESS = "getnewaddress";
    public final static String getaddresses = "getnewaddress";

    

    public static String EXPLORER_URL1 = "http://explorer.indexchain.io/";
    public static String EXPLORER_URL2 = "http://explorer.indexchain.io";


    public static String EXPLORER_URL_addr = "insight-api-komodo/addr/";
    public static String EXPLORER_URL_addrs = "insight-api-komodo/addrs/";
    public static String EXPLORER_URL_balance = "/balance";
    public static String EXPLORER_URL_utxo = "/utxo";
    //https://explorer.indexchain.io/insight-api-komodo/addrs/RGd77ChrgHVNgYU4ptXaofCCBYnkho1xJr/txs?from=0&to=10
    public static String EXPLORER_URL_txs = "/txs?";


    //transaction
    public final static String CREATETRANSACTION = "createrawtransaction";
    public final static String SIGNRAWTRANSACTION = "signrawtransaction";
    public final static String SENDRAWTRANSACTION = "sendrawtransaction";

    //rewards
    public final static String REWARDSADDFUNDING = "rewardsaddfunding";
    public final static String REWARDSADDRESS = "rewardsaddress";
    public final static String CREATEFUNDING = "rewardscreatefunding";
    public final static String REWARDSINFO = "rewardsinfo";
    public final static String REWARDSLIST = "rewardslist";
    public final static String REWARDSLOCK = "rewardslock";
    public final static String REWARDSUNLOCK = "rewardsunlock";

    //addr
    public final static String SENDTOADDRESS = "sendtoaddress";
}
