package com.songbo.server.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName TransactionResult
 * @Description TODO transaction返回的jsonobject中的result对象
 * @Author songbo
 * @Date 19-9-26 下午2:36
 **/
@Setter
@Getter
@ToString
public class TransactionResultForSignAndSend implements Serializable {
    private String hex;
    private Boolean complete;
}
