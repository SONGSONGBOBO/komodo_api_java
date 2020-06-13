package com.songbo.server.bean.rewards;

import lombok.Data;

/**
 * @ClassName rewardsaddressResult
 * @Description TODO
 * {
 *   "result": "success",
 *   "RewardsCCaddress": "RTsRBYL1HSvMoE3qtBJkyiswdVaWkm8YTK",
 *   "Rewardsmarker": "RMgye9jeczNjQx9Uzq8no8pTLiCSwuHwkz",
 *   "GatewaysPubkey": "03ea9c062b9652d8eff34879b504eda0717895d27597aaeb60347d65eed96ccb40",
 *   "RewardsCCassets": "RLh5sgvh3scCyM4aq1fhYhwgfbmb5SpCkT",
 *   "CCaddress": "RJdwcBsoWwmt9dtSqyFCULNW2F3zj2mcD3",
 *   "myCCaddress": "RJdwcBsoWwmt9dtSqyFCULNW2F3zj2mcD3",
 *   "myaddress": "RVXhz5UCJfSRoTfa4zvBFBrpDBbqMM21He"
 * }
 * @Author songbo
 * @Date 19-10-22 上午9:50
 **/
@Data
public class RewardsaddressResult {

    private String result;
    private String RewardsCCaddress;
    private String Rewardsmarker;
    private String GatewaysPubkey;
    private String RewardsCCassets;
    private String CCaddress;
    private String myCCaddress;
    private String myaddress;
}
