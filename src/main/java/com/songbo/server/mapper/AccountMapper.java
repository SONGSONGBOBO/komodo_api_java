package com.songbo.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songbo.server.entity.Account;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AccountMapper extends Mapper<Account> {
    Account getAccountById(int id);
    IPage<Account> getAccountListByPage(Page<Account> page, Integer status);
    String getPwdByName(String name);
    Account getAccountByName(String name);
    boolean deleteAccount(int id);
}