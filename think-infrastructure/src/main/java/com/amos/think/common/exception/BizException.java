package com.amos.think.common.exception;

import com.amos.think.dto.data.ErrorCode;

/**
 * 业务异常
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/27
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -2776433598172531409L;

    private final ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getErrDesc());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
