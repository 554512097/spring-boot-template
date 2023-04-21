/**
* *****************************************************************************
* Copyright © 1998 - 2020 CSG Shenzhen Digital Grid Research Institute Co.,Ltd.
* All Rights Reserved.
* 本软件为南方电网深圳数字电网研究院有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
* 复制、修改或发布本软件.
* <p>
*
* @Author: xiekun
* @Date: 2023-04-07
* @Description: 
* ****************************************************************************
*/
package com.bt.webtemplate.controller;

import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.webtemplate.dao.UserRepository;
import com.bt.webtemplate.utils.JWTUtils;
import com.bt.webtemplate.vo.BaseVO;
import com.bt.webtemplate.vo.UserInfoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("用户相关接口")
@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    public final UserRepository mUserRepository;

    public UserController(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public BaseVO<UserInfoVO> registerUser(@Validated @RequestBody UserInfoVO userInfo, HttpServletResponse response) {
        UserInfoVO user = mUserRepository.save(userInfo);
        String token = JWTUtils.generateToken(user.getId());
        response.setHeader("token", token);
        return BaseVO.success(user);
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public BaseVO<UserInfoVO> loginUser(
            @ApiParam(name = "账号", required = true) @NotBlank @Size(max = 50, message = "账号长度必须小于50个字符") @RequestParam String account,
            @ApiParam(name = "密码", required = true) @NotBlank @Size(min = 6, max = 30, message = "密码长度必须大于6个字符小于30个字符") @RequestParam String password,
            HttpServletResponse response) {
        UserInfoVO user = mUserRepository.getByAccount(account);
        if (user == null) {
            return BaseVO.errorHint("用户不存在");
        }
        if (!password.equals(user.getPassword())) {
            return BaseVO.errorHint("密码错误");
        }
        String token = JWTUtils.generateToken(user.getId());
        response.setHeader("token", token);
        return BaseVO.success(user);
    }

    @ApiOperation("更新")
    @PostMapping("/update")
    public BaseVO<UserInfoVO> updateUserInfo(@Validated @RequestBody UserInfoVO userInfo) {
        UserInfoVO user = mUserRepository.save(userInfo);
        return BaseVO.success(user);
    }

    @ApiOperation("用户信息")
    @GetMapping("/info")
    public BaseVO<UserInfoVO> getUserInfo(@RequestHeader("token") String token) {
        long uid = JWTUtils.validateToken(token);
        UserInfoVO user = mUserRepository.getById(uid);
        if (user == null) {
            return BaseVO.errorHint("用户不存在");
        }
        return BaseVO.success(user);
    }
}
