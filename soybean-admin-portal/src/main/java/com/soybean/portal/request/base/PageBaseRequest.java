package com.soybean.portal.request.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class PageBaseRequest extends BaseRequest {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    @Schema(description = "当前页")
    private Integer pageNumber = 1;

    /**
     * 每页数据数量
     */
    @Schema(description = "每页数据数量")
    private Integer pageSize = 10;

    /**
     * 查询关键字
     */
    @Schema(description = "查询关键字")
    private String keyword;

    public Integer getPageNumber() {
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        return pageNumber;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        return pageSize;
    }
}
