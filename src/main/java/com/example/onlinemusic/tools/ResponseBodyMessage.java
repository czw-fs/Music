package com.example.onlinemusic.tools;

import lombok.Data;

/**
 * @Author 12629
 * @Date 2022/4/11 11:52
 * @Description：
 */
@Data
public class ResponseBodyMessage <T>{
    private int status;//状态吗

    private String message;//返回的信息【出错的原因？  没错的原因？】

    private T data;//返回给前端的数据

    public ResponseBodyMessage(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
