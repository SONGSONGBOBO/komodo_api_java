package com.songbo.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Account {
    @Id
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_pwd")
    private String accountPwd;

    @Column(name = "account_create_time")
    private String accountCreateTime;

    @Column(name = "account_status")
    private Integer accountStatus;
    @Transient
    private List<Address> addressList;
    public Account(){}

    public Account(String accountName, String accountPwd, String accountCreateTime) {
        this.accountName = accountName;
        this.accountPwd = accountPwd;
        this.accountCreateTime = accountCreateTime;
    }
}