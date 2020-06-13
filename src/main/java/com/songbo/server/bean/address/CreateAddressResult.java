package com.songbo.server.bean.address;

import lombok.Data;

/**
 * @ClassName CreateAddressResult
 * @Description TODO
 * @Author songbo
 * @Date 19-10-15 下午1:53
 **/
@Data
public class CreateAddressResult {

    private String result;
    private Object error;
    private String id;

    public CreateAddressResult(){}

    public CreateAddressResult(String result, Object error, String id) {
        this.result = result;
        this.error = error;
        this.id = id;
    }
}
