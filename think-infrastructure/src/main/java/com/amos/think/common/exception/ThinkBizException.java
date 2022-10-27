package com.amos.think.common.exception;

import com.alibaba.cola.exception.BizException;
import com.amos.think.dto.data.ErrorCode;

/**
 * 业务异常
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/27
 */
public class ThinkBizException extends BizException {

    private static final long serialVersionUID = -2776433598172531409L;

    public ThinkBizException(ErrorCode errorCode) {
        super(errorCode.getErrCode(), errorCode.getErrDesc());
    }
}
