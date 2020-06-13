package com.songbo.server.controller;

import com.songbo.server.service.RPCRequestService;
import com.songbo.server.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author songbo
 * @Date 19-9-20 下午6:55
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RPCRequestService RPC;

    @GetMapping("/test")
    public ResultUtil test(){
        return ResultUtil.result200("test",RPC.rpcGetRequest("https://explorer.indexchain.io/insight-api-komodo/addr/RGd77ChrgHVNgYU4ptXaofCCBYnkho1xJr/balance"));
    }
}
