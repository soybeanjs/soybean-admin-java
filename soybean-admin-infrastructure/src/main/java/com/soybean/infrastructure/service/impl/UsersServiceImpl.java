package com.soybean.infrastructure.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.soybean.domain.model.UsersDTO;
import com.soybean.infrastructure.factory.mapper.UsersMapperFactory;
import com.soybean.infrastructure.resources.entity.UsersDO;
import com.soybean.infrastructure.resources.mapper.UsersDAO;
import com.soybean.infrastructure.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    @Autowired
    private UsersDAO usersDAO;


    @Override
    public UsersDTO login(UsersDTO usersDTO) {
        UsersDO usersDO = usersDAO.selectOneByQuery(new QueryWrapper().eq("username", usersDTO.getUsersBasic().getUsername()));
        return Optional.of(usersDO)
                .map(UsersMapperFactory.MAPPER::map)
                .orElse(null);
    }
}
