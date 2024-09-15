package com.soybean.infrastructure.resources.entity;

import com.mybatisflex.annotation.Id;
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
 *  用户和角色关联表 实体类。
 *
 * @author gutsyzhan
 * @since 2024-09-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("角色信息表")
@Table(value = "soybean_user_role")
public class UserRoleDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @ApiModelProperty("用户ID")
    private Long userId;

    /**
     * 角色ID
     */
    @Id
    @ApiModelProperty("角色ID")
    private Long roleId;

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
