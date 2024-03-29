package cn.soybean.system.domain.entity

import cn.soybean.framework.common.base.BaseTenantEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table

@Entity
@Table(
    name = "sys_role_menu", indexes = [
        Index(columnList = "tenant_id"),
        Index(columnList = "role_id, menu_id"),
        Index(columnList = "role_id"),
        Index(columnList = "menu_id")
    ]
)
class SystemRoleMenuEntity(

    /**
     * 角色ID
     */
    @Column(name = "role_id", nullable = false)
    val roleId: Long? = null,

    /**
     * 菜单ID
     */
    @Column(name = "menu_id", nullable = false)
    val menuId: Long? = null
) : BaseTenantEntity()
