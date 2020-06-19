package com.example.jwt.handle;

import com.example.jwt.enumeration.ReturnCode;
import lombok.Data;

/**
 * created by @author wangzelong 2020/6/3 10:45
 * 业务异常
 */
@Data
public class BusinessException extends RuntimeException {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 提示信息.
     */
    private String msg;
    /**
     * 业务异常数据
     */
    private Object data;

    public BusinessException() {
        this.code = ReturnCode.fail.getCode();
        this.msg = ReturnCode.fail.getMsg();
    }

    public BusinessException(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BusinessException(ReturnCode returnCode) {
        this.code = returnCode.getCode();
        this.msg = returnCode.getMsg();
    }
}
