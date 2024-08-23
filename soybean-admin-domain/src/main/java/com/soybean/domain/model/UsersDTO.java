package com.soybean.domain.model;

import lombok.Data;
import lombok.Getter;

@Data
public class UsersDTO {


    private Long userId;


    /**
     * 用户基础信息
     */
    private UsersBasic usersBasic;

    /**
     * 用户登录信息
     */
    private UsersLoginInfo usersLoginInfo;


    /**
     * 用户扩展信息
     */
    private UsersExtra usersExtra;


    @Data
    public static class UsersBasic {
        /**
         * 用户账号
         */
        private String username;

        /**
         * 密码
         */
        private String password;

        /**
         * 用户昵称
         */
        private String nickName;

        /**
         * 用户类型（00系统用户）
         */
        private UsersType usersType;

        /**
         * 用户邮箱
         */
        private String email;

        /**
         * 手机号码
         */
        private String phoneNumber;

        /**
         * 用户性别（0男 1女 2未知）
         */
        private Gender sex;

        /**
         * 头像地址
         */
        private String avatar;


        /**
         * 帐号状态（0正常 1停用）
         */
        private UsersState usersState;

        /**
         * 删除标志（0代表存在 2代表删除）
         */
        private String delFlag;

    }

    @Data
    public static class UsersLoginInfo {
        /**
         * 最后登录IP
         */
        private String loginIp;

        /**
         * 最后登录时间
         */
        private Long loginDate;
    }

    @Data
    public static class UsersExtra {
        /**
         * 创建时间
         */
        private Long gmtCreate;

        /**
         * 更新时间
         */
        private Long gmtModified;

        /**
         * 备注
         */
        private String extra;
    }

    @Getter
    public enum UsersState {


        enable(1, "启用"),
        disable(0, "禁用");

        private final Integer state;
        private final String desc;

        UsersState(Integer state, String desc) {
            this.state = state;
            this.desc = desc;
        }

        public static UsersState of(Integer state) {
            for (UsersState value : UsersState.values()) {
                if (value.getState().equals(state)) {
                    return value;
                }
            }
            return null;
        }

        public static Integer of(UsersState state) {
            for (UsersState value : UsersState.values()) {
                if (value.equals(state)) {
                    return value.getState();
                }
            }
            return null;
        }

    }

    @Getter
    public enum Gender {

        man(0, "男生"),
        woman(1, "女"),

        unknown(2, "未知");

        private final Integer state;
        private final String desc;

        Gender(Integer state, String desc) {
            this.state = state;
            this.desc = desc;
        }

        public static Integer of(Gender gender) {
            for (Gender value : values()) {
                if (value.equals(gender)) {
                    return value.getState();
                }
            }
            return null;
        }

        public static Gender of(Integer gender) {
            for (Gender value : values()) {
                if (value.getState().equals(gender)) {
                    return value;
                }
            }
            return null;
        }
    }

    @Getter
    public enum UsersType {

        sysUsers(0, "系统用户"),
        externalUsers(1, "外部用户"),

        unknown(2, "未知");

        private final Integer type;
        private final String desc;

        UsersType(Integer type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public static Integer of(UsersType usersType) {
            for (UsersType value : values()) {
                if (value.equals(usersType)) {
                    return value.getType();
                }
            }
            return null;
        }

        public static UsersType of(Integer usersType) {
            for (UsersType value : values()) {
                if (value.getType().equals(usersType)) {
                    return value;
                }
            }
            return null;
        }
    }


}
