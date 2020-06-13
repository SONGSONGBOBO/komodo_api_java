package com.songbo.server.bean.rewards;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.RPCResponse;
import com.songbo.server.bean.sendTransaction.RPCResponseForT;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName RewardscreatefundingResult
 * @Description TODO
 * @Author songbo
 * @Date 19-10-22 上午9:53
 **/
@Data
public class RewardscreatefundingResult implements Serializable {

    private String result;
    private String hex;


    public static void main(String[] args) {
        String  s = "{\"result\":{\"result\":\"success\",\"hex\":\"o\"},\"error\":null,\"id\":\"test11\"}\n";
        RPCResponseForT<RewardscreatefundingResult, String> rewardscreatefundingResult = JSONObject.toJavaObject((JSON)JSON.parse(s),RPCResponseForT.class);
        System.out.println(rewardscreatefundingResult);
    }
}
