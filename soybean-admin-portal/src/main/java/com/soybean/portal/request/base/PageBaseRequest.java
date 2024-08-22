package com.soybean.portal.request.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageBaseRequest extends BaseRequest {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer pageNumber = 1;

    /**
     * 每页数据数量
     */
    @ApiModelProperty(value = "每页数据数量")
    private Integer pageSize = 10;

    /**
     * 查询关键字
     */
    @ApiModelProperty(value = "查询关键字")
    private String keyword;

    public Integer getPageNumber() {
        if (pageNumber <= 0) {
            pageNumber = 10;
        }
        return pageNumber;
    }

    public Integer getPageSize() {
        if (pageSize <= 0) {
            pageSize = 1;
        }
        return pageSize;
    }
}
