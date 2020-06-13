package com.songbo.server.mapper;

import com.songbo.server.entity.Token;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TokenMapper extends Mapper<Token> {

    Token getTokenById(int id);
    List<Token> getTokenList();
    Token getTokenByTokenTxid(String txid);
}