/**
* *****************************************************************************
* Copyright © 1998 - 2020 CSG Shenzhen Digital Grid Research Institute Co.,Ltd.
* All Rights Reserved.
* 本软件为南方电网深圳数字电网研究院有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
* 复制、修改或发布本软件.
* <p>
*
* @Author: xiekun
* @Date: 2023-04-18
* @Description: 
* ****************************************************************************
*/
package com.bt.webtemplate.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import com.bt.webtemplate.vo.UserInfoVO;

public interface UserRepository extends CrudRepository<UserInfoVO, Long> {
    @Nullable
    UserInfoVO getById(long id);

    @Nullable
    UserInfoVO getByAccount(String account);
}
