package com.soybean.infrastructure.service;

import com.mybatisflex.core.service.IService;
import com.soybean.infrastructure.resources.entity.UsersDO;

/**
 * 用户信息表 服务层。
 *
 * @author coding
 * @since 2024-08-23
 */
public interface UsersService extends IService<UsersDO> {

    void login(Object o);
}
