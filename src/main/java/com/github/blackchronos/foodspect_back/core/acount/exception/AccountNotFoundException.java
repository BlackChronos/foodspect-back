package com.github.blackchronos.foodspect_back.core.acount.exception;


import com.github.blackchronos.foodspect_back.exception.AbstractMonoException;

public class AccountNotFoundException extends AbstractMonoException {
    public AccountNotFoundException(String message, Object... arguments) {
        super(message, arguments);
    }
}
