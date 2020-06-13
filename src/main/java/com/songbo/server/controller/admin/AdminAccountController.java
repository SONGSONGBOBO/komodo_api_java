package com.songbo.server.controller.admin;

import com.songbo.server.entity.Account;
import com.songbo.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AdminAccountController
 * @Description TODO
 * @Author songbo
 * @Date 19-10-10 下午4:37
 **/
@RestController
@RequestMapping("/server")
public class AdminAccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/allAcount")
    public List<Account> getAccountListByPage(){



        return null;
    }
}
