package com.soybean.common;

import java.io.Serializable;

import com.soybean.common.constants.enums.ResultCode;
import lombok.Data;

/**
 * @description:
 * @author：美式续命
 * @date: 2024/6/23
 * @Copyright：
 */
@Data
public class Result<T> implements Serializable {

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result failed(ResultCode resultCode, String message) {
        return new Result(resultCode.getCode(), message, null);
    }

    public static <T> Result failed(ResultCode resultCode, T data) {
        return new Result(resultCode.getCode(), resultCode.getMessage(), data);
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = code == 200;
    }

    public static <T> Result success(T data) {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result success(String message, T data) {
        return new Result(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static Result failed(ResultCode resultCode) {
        return new Result(resultCode.getCode(), resultCode.getMessage(), null);
    }

    public static Result failed(String message) {
        return new Result(ResultCode.UNKNOWN_ERROR.getCode(), message, null);
    }

    public static <T> Result failed(T data, ResultCode resultCode, String msg) {
        return new Result(resultCode.getCode(), msg, data);
    }

    public boolean isSuccess() {
        return success = code == 200;
    }

}