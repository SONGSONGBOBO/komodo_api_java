package com.songbo.server.bean.sendTransaction;

import com.songbo.server.bean.ErrorResult;
import com.songbo.server.bean.TransactionResultForSignAndSend;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName RPCResponseForSend
 * @Description TODO
 * @Author songbo
 * @Date 19-10-18 下午3:24
 **/
@Setter
@Getter
@ToString
public class RPCResponseForSend {
    private String result;
    private ErrorResult error;
    private String id;

    public RPCResponseForSend(){}

    public RPCResponseForSend(String result, ErrorResult error, String id) {
        this.result = result;
        this.error = error;
        this.id = id;
    }
}
