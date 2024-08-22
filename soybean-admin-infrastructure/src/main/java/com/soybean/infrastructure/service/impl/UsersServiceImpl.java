package com.soybean.infrastructure.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.soybean.domain.model.UsersDTO;
import com.soybean.domain.service.UsersService;
import com.soybean.infrastructure.resources.entity.UsersDO;
import com.soybean.infrastructure.resources.mapper.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息表 服务层实现。
 *
 * @author coding
 * @since 2024-08-20
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersDAO, UsersDO> implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public UsersDTO login(UsersDTO dto) {
        return null;
    }
}
