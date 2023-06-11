package com.github.blackchronos.foodspect_back.core.producer.exception;

import com.github.blackchronos.foodspect_back.exception.AbstractMonoException;

public class ProducerNotFoundException extends AbstractMonoException {
    public ProducerNotFoundException(String message, Object... arguments) {
        super(message, arguments);
    }
}
