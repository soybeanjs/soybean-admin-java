package com.soybean.infrastructure.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.soybean.infrastructure.resources.entity.RoleMenuDO;
import com.soybean.infrastructure.resources.mapper.RoleMenuDAO;
import com.soybean.infrastructure.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 *  角色和菜单关联表 服务层实现。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDAO, RoleMenuDO> implements RoleMenuService {

}
