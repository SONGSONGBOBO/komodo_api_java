package com.songbo.server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.songbo.server.service.ExplorerService;
import com.songbo.server.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExplorerController
 * @Description TODO
 * @Author songbo
 * @Date 19-9-20 下午9:08p
 **/
@RestController
@RequestMapping("/explorer")
public class ExplorerController {

    @Autowired
    private ExplorerService explorerService;

    @PostMapping("/getBalance")
    public ResultUtil getBalanceByaddr(@RequestBody JSONObject jsonObject){
        String addr = jsonObject.getString("addr");

        String result = explorerService.getBalance(addr);
        if (!result.equals("fail")){
            return ResultUtil.result200("success", result);
        } else {
            return ResultUtil.result500("fail", result);
        }

    }

    @PostMapping("/getTxs")
    public ResultUtil getTxsByaddr(@RequestBody JSONObject jsonObject) {
        String addr = jsonObject.getString("addr");
        String from = jsonObject.getString("from");
        String to = jsonObject.getString("to");

        String result = explorerService.getTxs(from, to, addr);
        if (!result.equals("fail")){
            return ResultUtil.result200("success", JSON.parse(result));
        } else {
            return ResultUtil.result500("fail", result);
        }

    }

    @PostMapping("/getHistory")
    public ResultUtil getHistory(@RequestBody JSONObject jsonObject) {
        String addr = jsonObject.getString("addr");
        String from = jsonObject.getString("from");
        String to = jsonObject.getString("to");

        String result = explorerService.getTxs(from, to, addr);
        if (!result.equals("fail")){
            return ResultUtil.result200("success", JSON.parse(result));
        } else {
            return ResultUtil.result500("fail", result);
        }

    }
}
