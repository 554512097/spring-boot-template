package com.bt.webtemplate.consts;

/**
 * @Author: 谢昆
 * @Date: 2022/9/11
 * @Description: 无
 * *****************************************************************************
 */
public interface ResponseCode {
    /**
     * 接口成功请求的状态码
     */
    int SUCCESS = 2000;

    /**
     * 接口未通过认证的状态码
     */
    int UNAUTHORIZED = 1001;

    /**
     * 接口请求失败且仅进行错误提示的状态码
     */
    int ERROR = 3000;
}
