package com.songbo.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songbo.server.entity.Account;

import java.util.List;

/**
 * @ClassName AccountService
 * @Description TODO
 * @Author songbo
 * @Date 19-9-30 下午12:01
 **/
public interface AccountService {
    /**
      *@Description TODO
      *@param
      *@return
    **/
    boolean varifyAccount(String name, String pwd);
    /**
      *@Description TODO
      *@param
      *@return
    **/
    boolean insertAccount(Account account);
    /**
      *@Description TODO
      *@param
      *@return
    **/
    Account getAccountByName(String name);
    /**
     *@Description TODO
     *@param
     *@return
     **/
    Account getAccountById(int id);
    /**
      *@Description TODO
      *@param
      *@return
    **/
    List<Account> getAccountList();
    /**
      *@Description TODO
      *@param
      *@return
    **/
    boolean deleteAccountById(int id);
    /**
      *@Description TODO
      *@param
      *@return
    **/
    IPage<Account> getAccountByPage(Page<Account> page, Integer status);
}
