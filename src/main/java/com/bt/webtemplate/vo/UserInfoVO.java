/**
* @Author: xiekun
* @Date: 2022-11-25
* @Description: 
*/
package com.bt.webtemplate.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserInfoVO {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 20)
    private String phone;

    @NotBlank
    @Size(max = 50, message = "账号长度必须小于50个字符")
    @Column(nullable = false, length = 50, unique = true)
    private String account;

    @NotBlank
    @Size(min = 6, max = 30, message = "密码长度必须大于6个字符小于30个字符")
    @Column(nullable = false)
    private String password;

    @Column(length = 50)
    private String nick;

    @Column(length = 255)
    private String address;

    @Column
    private byte age;

    @Column(columnDefinition = "text")
    private String introduce;
}
