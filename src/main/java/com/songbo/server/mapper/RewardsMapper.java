package com.songbo.server.mapper;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.songbo.server.entity.Rewards;

public interface RewardsMapper extends Mapper<Rewards> {

    boolean createRewards(String name,String addr, String message, int status);
}
