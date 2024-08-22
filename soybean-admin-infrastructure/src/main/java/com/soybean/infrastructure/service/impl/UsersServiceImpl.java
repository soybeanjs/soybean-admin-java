package com.soybean.infrastructure.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.soybean.infrastructure.resources.entity.UsersDO;
import com.soybean.infrastructure.resources.mapper.UsersDAO;
import com.soybean.infrastructure.service.UsersService;
import org.springframework.stereotype.Service;

/**
 * 用户信息表 服务层实现。
 *
 * todo @山月这个实现还没想好要不要下掉，先留着用吧，毕竟用着方便
 *
 * @author coding
 * @since 2024-08-23
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersDAO, UsersDO> implements UsersService {

    @Override
    public void login(Object o) {

    }
}
