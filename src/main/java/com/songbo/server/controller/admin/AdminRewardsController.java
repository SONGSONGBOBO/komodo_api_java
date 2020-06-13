package com.songbo.server.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.songbo.server.bean.rewards.RewardscreatefundingResult;
import com.songbo.server.service.RewardsService;
import com.songbo.server.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialStruct;

/**
 * @ClassName AdminRewardsController
 * @Description TODO
 * @Author songbo
 * @Date 19-10-22 下午1:48
 **/
@RestController
@RequestMapping("/admin/rewards")
public class AdminRewardsController {

    @Autowired
    private RewardsService rewardsService;

    @PostMapping("/createRewards")
    public ResultUtil createRewards(@RequestBody JSONObject jsonObject){
        String name = jsonObject.getString("name");
        String amount = jsonObject.getString("amount");
        String rate = jsonObject.getString("rate");
        String mindays = jsonObject.getString("mindays");
        String maxdays = jsonObject.getString("maxdays");
        String minMoney = jsonObject.getString("minMoney");

        /*try {
            RewardscreatefundingResult funding1 = rewardsService.createFunding(name, amount, rate, mindays, maxdays, minMoney);
            if (funding!= null){
                return ResultUtil.result200("添加成功" , funding);
            }else {
                return ResultUtil.result400("请求有误", null);
            }
        } catch (Exception e){
            return ResultUtil.result400("请求有误", e);
        }*/
        return null;
    }
}
