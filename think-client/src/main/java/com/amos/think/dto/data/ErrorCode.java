package com.amos.think.dto.data;

/**
 * 错误信息
 *
 * @author amos
 */
public enum ErrorCode {
    /**
     * 尽量让code可以达意
     */
    B_USER_USERNAME_REPEAT("B_USER_usernameRepeat", "用户名重复"),
    B_USER_UNDEFINED("B_USER_undefined", "用户不存在"),
    B_USER_PASSWORD_ERROR("B_USER_passwordError", "用户名或密码不正确");

    private final String errCode;
    private final String errDesc;

    ErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }
}
