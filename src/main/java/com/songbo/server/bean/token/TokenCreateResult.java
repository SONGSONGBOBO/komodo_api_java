package com.songbo.server.bean.token;

import lombok.Data;

/**
 * @ClassName TokenCreateResult
 * @Description TODO
 * @Author songbo
 * @Date 19-10-5 下午4:29
 **/
@Data
public class TokenCreateResult {
    private ResultForTokenCreateResult result;
    private Object error;
    private String id;
}
