package com.songbo.server.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songbo.server.entity.Account;
import com.songbo.server.mapper.AccountMapper;
import com.songbo.server.service.AccountService;
import com.songbo.server.utils.BcryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author songbo
 * @Date 19-9-30 下午12:06
 **/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public boolean varifyAccount(String name, String pwd) {
        String spwd = accountMapper.getPwdByName(name);
        if (spwd != null){
            if (BcryptUtil.decryption(pwd, spwd)){
                return true;
            }else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean insertAccount(Account account) {
        try {
            accountMapper.insert(account);
            log.warn("insert account ", account);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Account getAccountByName(String name) {
        Account account = accountMapper.getAccountByName(name);
        return account;
    }

    @Override
    public Account getAccountById(int id) {
        try {
            Account accountById = accountMapper.getAccountById(id);
            return accountById;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Account> getAccountList() {
        return accountMapper.selectAll();
    }

    @Override
    public boolean deleteAccountById(int id) {
        try {
            accountMapper.deleteAccount(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public IPage<Account> getAccountByPage(Page<Account> page, Integer status) {
        return accountMapper.getAccountListByPage(page,status);
    }
}
