package com.soybean.infrastructure.resources.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;

/**
 *  菜单权限表 实体类。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("菜单权限表")
@Table(value = "soybean_menu")
public class MenuDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @Id(keyType = KeyType.Auto)
    @ApiModelProperty("菜单ID")
    private Long menuId;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String menuName;

    /**
     * 父菜单ID
     */
    @ApiModelProperty("父菜单ID")
    private Long parentId;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    /**
     * 路由地址
     */
    @ApiModelProperty("路由地址")
    private String path;

    /**
     * 组件路径
     */
    @ApiModelProperty("组件路径")
    private String component;

    /**
     * 是否为外链（0是 1否）
     */
    @ApiModelProperty("是否为外链（0是 1否）")
    private Integer isFrame;

    /**
     * 是否缓存（0缓存 1不缓存）
     */
    @ApiModelProperty("是否缓存（0缓存 1不缓存）")
    private Integer isCache;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    @ApiModelProperty("菜单状态（0正常 1停用）")
    private String status;

    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String perms;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String icon;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Long gmtCreate;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Long gmtModified;

    /**
     * 创建者
     */
    @ApiModelProperty("创建者")
    private Long createBy;

    /**
     * 更新者
     */
    @ApiModelProperty("更新者")
    private Long updateBy;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String extra;

}
