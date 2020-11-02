package com.zzz.hathor.codemaker.util.exception;

public class TooManyPatchedMethodsException extends  Exception {
    public TooManyPatchedMethodsException(String message, Throwable cause) {
        super("太多相匹配的方法", cause);
    }
}
