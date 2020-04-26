package com.qingcheng.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private Integer code;//业务返回码  0：成功  1:错误

    private String message;//消息

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.code=0;
        this.message="执行成功";
    }

}
