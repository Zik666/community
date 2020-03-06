package com.zik666.community.exception;

/**
 * @author : Zik666
 * @date : 0:36 2020-02-24
 */
public class CustomizeException extends RuntimeException {
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

}
