package com.soybean.infrastructure.resources.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "用户和角色关联表")
@Table(value = "soybean_user_role")
public class UserRoleDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @Schema(description = "用户ID")
    private Long userId;

    /**
     * 角色ID
     */
    @Id
    @Schema(description = "角色ID")
    private Long roleId;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @Schema(description = "删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Long gmtCreate;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Long gmtModified;

    /**
     * 创建者
     */
    @Schema(description = "创建者")
    private Long createBy;

    /**
     * 更新者
     */
    @Schema(description = "更新者")
    private Long updateBy;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String extra;
}
