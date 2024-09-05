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
 * 角色信息表 实体类。
 *
 * @author gutsyzhan
 * @since 2024-09-05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色信息表")
@Table(value = "soybean_role")
public class RoleDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @Id(keyType = KeyType.Auto)
    @ApiModelProperty("角色ID")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色权限字符串
     */
    @ApiModelProperty("角色权限字符串")
    private String roleKey;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer roleSort;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @ApiModelProperty("数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private String dataScope;

    /**
     * 菜单树选择项是否关联显示
     */
    @ApiModelProperty("菜单树选择项是否关联显示")
    private Boolean menuCheckStrictly;

    /**
     * 部门树选择项是否关联显示
     */
    @ApiModelProperty("部门树选择项是否关联显示")
    private Boolean deptCheckStrictly;

    /**
     * 角色状态（0正常 1停用）
     */
    @ApiModelProperty("角色状态（0正常 1停用）")
    private String status;

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
