package com.soybean.common.constants.enums;

/**
 * @description:响应状态码
 * @author：美式续命
 * @date: 2024/6/23
 * @Copyright：
 */

public enum ResultCode {
    /**
     * 参数校验不通过
     */
    PARAM_CHECK_ERROR(100, "param check error;"),
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 调用平台接口异常
     */
    PLATFORM_ERROR(300, "Call platform openApi error;"),

    /**
     * 平台token过期或接口欠费
     */
    PLATFORM_TOKEN_FAIL(301, "token is invalid;"),

    /**
     * 平台响应失败
     */
    PLATFORM_FAIL(400, "platform openApi return fail;"),

    AUTH_FAIL(401, "请登录;"),

    /**
     * 自定义业务异常
     */
    BUSINESS_ERROR(470, "business error;"),

    /**
     * 编码解析异常
     */
    JSON_PARSE_ERROR(480, "channel hub json parse error;"),

    /**
     * 编码解析异常
     */
    ENCODE_ERROR(490, "channel hub encode error;"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(500, "unknown error;"),

    /**
     * 登陆失败
     */
    LOGIN_ERROR(501, "user login error;"),

    /**
     * 注册失败
     */
    REGISTER_ERROR(502, "user register error;"),

    /**
     * 未查询到数据
     */
    NOT_FOUND(998, "该渠道暂不支持该场景"),

    BINDING_GOOGLE_TWO_FACTOR_VALIDATE(10001, "请扫码绑定谷歌验证器"),

    GOOGLE_VERIFICATION_CODE_IS_INCORRECT_OR_HAS_TIMED_OUT(10002, "谷歌验证码不正确或已超时"),
    CODE_INVALID(10003, "验证码失效或错误，请重试"),

    SIGN_IN_TODAY(10005, "今日已签到"),

    /**
     * 渠道不支持场景
     */
    NOT_SUPPORT(999, "该渠道暂不支持该场景");

    /**
     * 结果码
     */
    private final Integer code;

    /**
     * 结果码描述
     */
    private final String message;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
