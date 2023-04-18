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

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.webtemplate.dao.UserRepository;
import com.bt.webtemplate.vo.BaseVO;
import com.bt.webtemplate.vo.UserInfoVO;

@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    public final UserRepository mUserRepository;
    private UserInfoVO user;

    public UserController(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    @PostMapping("/register")
    public BaseVO<UserInfoVO> registerUser(@Validated @RequestBody UserInfoVO userInfo) {
        return null;
    }

    @PostMapping("/login")
    public BaseVO<UserInfoVO> loginUser(
           @NotBlank @Size(max = 50, message = "账号长度必须小于50个字符") @RequestParam String account,
           @NotBlank @Size(min = 6, max = 30, message = "密码长度必须大于6个字符小于30个字符") @RequestParam String password) {
        List<UserInfoVO> users = mUserRepository.getByAccount(account);
        if (users.size() == 0) {
            return BaseVO.errorHint("用户不存在");
        }
        user = users.get(0);
        if (!password.equals(user.getPassword())) {
            return BaseVO.errorHint("密码错误");
        }
        return BaseVO.success(user);
    }

    @PostMapping("/update")
    public BaseVO<UserInfoVO> updateUserInfo(@Validated @RequestBody UserInfoVO userInfo) {
        return null;
    }

    @GetMapping("/info")
    public BaseVO<UserInfoVO> getUserInfo() {
        return null;
    }
}
