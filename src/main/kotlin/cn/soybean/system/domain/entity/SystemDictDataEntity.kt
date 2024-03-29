package cn.soybean.system.domain.entity

import cn.soybean.framework.common.base.BaseEntity
import cn.soybean.framework.common.consts.DbConstants
import cn.soybean.framework.common.consts.enums.DbEnums
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table

@Entity
@Table(
    name = "sys_dict_data", indexes = [
        Index(columnList = "dict_type")
    ]
)
class SystemDictDataEntity(

    /**
     * 排序
     */
    @Column(name = "sequence", nullable = false)
    var order: Int? = null,

    /**
     * 字典标签
     */
    @Column(name = "label", nullable = false, length = DbConstants.LENGTH_20)
    var label: String? = null,

    /**
     * 字典键值
     */
    @Column(name = "value", nullable = false, length = DbConstants.LENGTH_20)
    var value: String? = null,

    /**
     *
     */
    @Column(name = "dict_type", nullable = false, length = DbConstants.LENGTH_20)
    var dictType: String? = null,

    /**
     * 状态
     */
    @Column(name = "status")
    var status: DbEnums.Status = DbEnums.Status.ENABLED,

    @Column(name = "color", length = DbConstants.LENGTH_20)
    var color: String? = null,

    @Column(name = "type", length = DbConstants.LENGTH_20)
    var type: String? = null,

    @Column(name = "remark")
    var remark: String? = null
) : BaseEntity()
