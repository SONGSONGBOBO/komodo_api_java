package com.songbo.server.bean.sendTransaction;

import lombok.Data;

/**
 * @ClassName RPCResponseForT
 * @Description TODO
 * @Author songbo
 * @Date 19-10-22 下午1:00
 **/
@Data
public class RPCResponseForT<T, V> {

    private T result;
    private V error;
    private String id;

    public RPCResponseForT(T result, V error, String id) {
        this.result = result;
        this.error = error;
        this.id = id;
    }
}
