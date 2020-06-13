package com.songbo.server.bean.token;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName TokenListResult
 * @Description TODO
 * @Author songbo
 * @Date 19-10-5 下午4:08
 **/
@Data
public class TokenListResult implements Serializable {

    private List<String> result;
    private Object error;
    private String id;

}
