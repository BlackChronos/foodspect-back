package com.github.blackchronos.foodspect_back.core.acount.exception;


import com.github.blackchronos.foodspect_back.exception.AbstractMonoException;

public class AccountAlreadyExistsException extends AbstractMonoException {
    public AccountAlreadyExistsException(String message, Object... arguments) {
        super(message, arguments);
    }
}
