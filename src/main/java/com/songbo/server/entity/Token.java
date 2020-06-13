package com.songbo.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
public class Token {
    @Id
    @Column(name = "token_id")
    private Integer tokenId;

    @Column(name = "token_name")
    private String tokenName;

    @Column(name = "token_txid")
    private String tokenTxid;



}