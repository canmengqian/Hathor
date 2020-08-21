package com.zzz.hathor.captcha.domain.Enum;

/**
 *  验证结果信息
 */
public enum VerifyResultEnum {
    SUCCESS(1000,"验证成功"),
    FAIL(5000,"验证失败");
    private int code ;
    private String msg;

    VerifyResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
