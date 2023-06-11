package com.github.blackchronos.foodspect_back.core.acount.exception;


import com.github.blackchronos.foodspect_back.exception.AbstractMonoException;

public class BadCredentialsException extends AbstractMonoException {
    public BadCredentialsException(String message, Object... arguments) {
        super(message, arguments);
    }
}
