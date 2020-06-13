package com.songbo.server.controller;

import com.songbo.server.entity.Address;
import com.songbo.server.service.AddressService;
import com.songbo.server.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName addressController
 * @Description TODO
 * @Author songbo
 * @Date 19-9-19 下午1:57
 **/
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/createAddress")
    public ResultUtil createAddress(){

        String address = addressService.createNewAdress();
        if (address != null){
            return ResultUtil.result200("success", address);
        } else {
            return ResultUtil.result500("服务器错误！", "创建地址失败！");
        }
    }

    @RequestMapping("/getAddress")
    public ResultUtil getAddress(){

        String address = addressService.getAddresses();
        if (address != null){
            return ResultUtil.result200("success", address);
        } else {
            return ResultUtil.result500("服务器错误！", "创建地址失败！");
        }
    }
}
