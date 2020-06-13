package com.songbo.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
public class Address {
    @Id
    @Column(name = "addr_id")
    private Integer addrId;

    @Column(name = "addr_name")
    private String addrName;

    @Column(name = "addr_create_time")
    private String addrCreateTime;

    @Column(name = "addr_account_id")
    private Integer addrAccountId;



}