package com.songbo.server.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName errorResult
 * @Description TODO
 * @Author songbo
 * @Date 19-9-26 下午8:00
 **/
@Setter
@Getter
@ToString
public class ErrorResult implements Serializable {
    private String code;
    private String message;
}
