package com.songbo.server;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songbo.server.entity.Account;
import com.songbo.server.entity.Address;
import com.songbo.server.mapper.AccountMapper;
import com.songbo.server.mapper.AddressMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DicserverApplicationTests {
    @Autowired
    private AccountMapper accountMapper;
    @Resource
    private AddressMapper addrMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetUserListByUser(){

        List<Address> addressListByAccount = addrMapper.getAddrsByAccountId(1);
        for (Address address : addressListByAccount){
            System.out.println(address.getAddrName());
        }

    }

    @Test
    public void testAccountPage(){
        Page<Account> accountPage = new Page<Account>(1,5);
        IPage<Account> accountListByPage = accountMapper.getAccountListByPage(accountPage, 1);
        System.out.println(JSONObject.toJSON(accountListByPage));
    }

    @Value("${spring.mail.username}")
    private String mailTddr;
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void testMail(){
        //System.out.println(mailTddr);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailTddr);
        mailMessage.setTo("1127568060@qq.com");
        mailMessage.setSubject("test");
        mailMessage.setText("1111");
        mailSender.send(mailMessage);
        System.out.println("s");

    }

}
