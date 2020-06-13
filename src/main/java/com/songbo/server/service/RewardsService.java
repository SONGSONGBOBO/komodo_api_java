package com.songbo.server.service;

import com.songbo.server.bean.rewards.*;

import javax.servlet.ServletRequest;
import java.util.SplittableRandom;

public interface RewardsService {

    RewardsaddfundingResult addfunding(String name, String fundingtxid, String amount);
    RewardsaddressResult rewardsaddress(String pubkey);
    /**
      *@Description TODO
      *@param 名称 从您的钱包中提取的种子资金数量 年利率 最小天数 最大天数 最小存款数
      *@return plantxid
    **/
    RewardscreatefundingResult createFunding(
            String name, String amount, String rate, String mindays, String maxdays, String minmoney);

    RewardsinfoResult rewardsinfo(String fundingtxid);
    RewardslistResult rewardslist();
    RewardslockResult rewardslock(String name, String fundingtxid, String amount);
    RewardsunlockResult rewardsunlock(String name, String fundingtxid, String txid);
}
