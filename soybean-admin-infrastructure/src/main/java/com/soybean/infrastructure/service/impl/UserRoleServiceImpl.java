package com.soybean.infrastructure.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.soybean.infrastructure.resources.entity.UserRoleDO;
import com.soybean.infrastructure.resources.mapper.UserRoleDAO;
import com.soybean.infrastructure.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 *  用户和角色关联表 服务层实现。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDAO, UserRoleDO> implements UserRoleService {

}
