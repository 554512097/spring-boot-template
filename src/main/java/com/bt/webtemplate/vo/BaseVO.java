/**
* @Author: xiekun
* @Date: 2022-11-25
* @Description: 
*/
package com.bt.webtemplate.vo;

import com.bt.webtemplate.consts.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseVO<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> BaseVO<T> success(T data) {
        return new BaseVO<>(ResponseCode.SUCCESS, "请求成功", data);
    }

    public static <T> BaseVO<T> errorHint(String msg) {
        return new BaseVO<>(ResponseCode.ERROR, msg, null);
    }

    public static <T> BaseVO<T> error(int code, String msg) {
        return new BaseVO<>(code, msg, null);
    }

    public static <T> BaseVO<T> unauthorized() {
        return new BaseVO<>(ResponseCode.UNAUTHORIZED, "认证错误", null);
    }
}
