package com.songbo.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Rewards
 * @Description TODO
 * @Author songbo
 * @Date 19-10-22 上午9:56
 **/
@Table(name = "rewards")
@Data
public class Rewards {
    @TableId("rewards_id")
    private Integer rewardsId;
    @TableField("rewards_addr")
    private String rewardsAddr;
    @TableField("rewards_name")
    private String rewardsName;
    @TableField("rewards_message")
    private String rewardsMessage;
    @TableField("rewards_status")
    private Integer rewardsStatus;
}
