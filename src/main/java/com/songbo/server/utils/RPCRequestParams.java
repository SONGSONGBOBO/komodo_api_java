package com.songbo.server.utils;

/**
 * @ClassName RPCRequestParams
 * @Description TODO
 * @Author songbo
 * @Date 19-9-19 下午2:13
 **/
public class RPCRequestParams {

    //2:
/*    public final static String NODE_LOGIN = "user2093232109";
    public final static String NODE_PASS = "pass1e87a3b95c4efd3a6521ce364e69c8e8f3d512cb0546880216d56f4bbe684fe37a";*/
    //1:
    public final static String NODE_LOGIN = "user1142398450";
    public final static String NODE_PASS = "passfc998a78368d32d9b7eaec150cded8771f53161298ee49179b6f3835a7346c1944";
    //public final static String NODE_ADDRESS = "http://172.104.191.125:21331";
    //2:
    /*public final static String NODE_ADDRESS = "http://45.77.249.65:56689";
    public final static String NODE_ADDRESS_STANDBY = "http://172.104.191.125:48903";*/
    //1:

    public final static String NODE_ADDRESS = "http://139.180.128.178:56689";
    public final static String NODE_ADDRESS_STANDBY = "http://172.104.191.125:48903";
    //public final static double DIC_FEE = 0.00005;
    public final static double DIC_FEE = 0.0001;


    public final static String CREATE_ADDRESS = "getnewaddress";
    public final static String getaddresses = "getnewaddress";

    //explorer
    //public static String EXPLORER_URL1 = "http://172.104.191.125:45893/";
    //public static String EXPLORER_URL2 = "http://172.104.191.125:48906/";

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
