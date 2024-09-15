package com.soybean.infrastructure.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.soybean.infrastructure.resources.entity.MenuDO;
import com.soybean.infrastructure.resources.mapper.MenuDAO;
import com.soybean.infrastructure.service.MenuService;
import org.springframework.stereotype.Service;

/**
 *  菜单权限表 服务层实现。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDAO, MenuDO> implements MenuService {

}
