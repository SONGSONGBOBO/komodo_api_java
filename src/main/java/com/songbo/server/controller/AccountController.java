package com.songbo.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.songbo.server.entity.Account;
import com.songbo.server.service.AccountService;
import com.songbo.server.utils.BcryptUtil;
import com.songbo.server.utils.JwtUtil;
import com.songbo.server.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName AccountController
 * @Description TODO
 * @Author songbo
 * @Date 19-9-30 下午12:52
 **/
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResultUtil login(@RequestBody JSONObject jsonObject) {
        String name = jsonObject.getString("accountName");
        String pwd = jsonObject.getString("accountPwd");

        if (accountService.varifyAccount(name, pwd)){
            try {
                String token = JwtUtil.createJWT(name);
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("accountName", name);
                jsonObject1.put("token", token);
                return ResultUtil.result200("success", jsonObject1);
            } catch (Exception e){
                return ResultUtil.result500("服务器错误！","login: token "+e);
            }
        } else {
            return ResultUtil.result400("用户不存在或者密码不正确！",null);
        }

    }

    @PostMapping("/regiter")
    public ResultUtil regiter(@RequestBody JSONObject jsonObject) {
        String name = jsonObject.getString("accountName");
        String pwd = jsonObject.getString("accountPwd");
        String time = String.valueOf(System.currentTimeMillis());

        Account account = new Account(name, pwd, time);
        if (accountService.getAccountByName(name) == null && accountService.insertAccount(account)){
            return ResultUtil.result200("success", null);
        } else {
            return ResultUtil.result400("当前用户已存在！", null);
        }
    }

    @PostMapping("/appeal")
    public ResultUtil appeal(@RequestBody JSONObject jsonObject){
        String name = jsonObject.getString("accountName");
        return null;
    }
}
