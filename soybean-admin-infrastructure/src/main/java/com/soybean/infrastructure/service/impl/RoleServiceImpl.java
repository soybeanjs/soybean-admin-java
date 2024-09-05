package com.soybean.infrastructure.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.soybean.infrastructure.resources.entity.RoleDO;
import com.soybean.infrastructure.resources.mapper.RoleDAO;
import com.soybean.infrastructure.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色信息表 服务层实现。
 *
 * @author gutsyzhan
 * @since 2024-09-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDAO, RoleDO> implements RoleService {

}
