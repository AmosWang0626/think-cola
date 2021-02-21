package com.amos.think.dto.data;

/**
 * 错误信息
 *
 * @author amos
 */
public enum ErrorCode {
    /***/
    B_USER_usernameRepeat("B_USER_usernameRepeat", "用户名重复"),
    B_USER_usernameError("B_USER_usernameError", "用户名不存在"),
    B_USER_passwordError("B_USER_passwordError", "用户名或密码不正确");

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
