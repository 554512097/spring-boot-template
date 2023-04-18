package com.bt.webtemplate.consts;

/**
 * ******************************************************************************
 * Copyright © 1998 - 2020 CSG Shenzhen Digital Grid Research Institute Co.,Ltd.
 * All Rights Reserved.
 * 本软件为南方电网深圳数字电网研究院有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 * <p>
 *
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
