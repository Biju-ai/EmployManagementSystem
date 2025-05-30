package com.example.EmployManagementSystem.Util;

import org.springframework.http.HttpStatus;

public class ResponceUtil {
    public static ApiResponce getFailMsg(Integer code,String msg){
        return ApiResponce.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .code(code)
                .message(msg)
                .build();

    }
    public static ApiResponce getSuccessMsg(Integer code,String msg){
        return ApiResponce.builder()
                .status(HttpStatus.OK)
                .code(code)
                .message(msg)
                .build();
    }
    public static ApiResponce getSuccessMsg(Integer code,String message,Object data){
        return ApiResponce.builder()
                .status(HttpStatus.OK)
                .code(code)
                .message(message)
                .data(data)
                .build();
    }


}
