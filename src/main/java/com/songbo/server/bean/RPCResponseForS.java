package com.songbo.server.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName RPCResponseForS
 * @Description TODO
 * @Author songbo
 * @Date 19-9-27 上午10:57
 **/
@Setter
@Getter
@ToString
public class  RPCResponseForS implements Serializable {
    private TransactionResultForSignAndSend result;
    private ErrorResult error;
    private String id;

    public RPCResponseForS(){}

    public RPCResponseForS(TransactionResultForSignAndSend result, ErrorResult error, String id) {
        this.result = result;
        this.error = error;
        this.id = id;
    }
}
