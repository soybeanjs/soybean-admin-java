package com.soybean.infrastructure;

import com.soybean.infrastructure.constants.enums.ResultCode;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 统一响应结果。
 *
 * @author 美式续命
 * @since 2024/6/23
 */
@Data
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应提示
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = ResultCode.SUCCESS.getCode().equals(code);
    }

    public static <T> Result<T> failed(ResultCode resultCode, String message) {
        return new Result<>(resultCode.getCode(), message, null);
    }

    public static <T> Result<T> failed(ResultCode resultCode, T data) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> failed(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), null);
    }

    public static <T> Result<T> failed(String message) {
        return new Result<>(ResultCode.UNKNOWN_ERROR.getCode(), message, null);
    }

    public static <T> Result<T> failed(T data, ResultCode resultCode, String msg) {
        return new Result<>(resultCode.getCode(), msg, data);
    }
}
