package com.github.blackchronos.foodspect_back.core.supplement.exception;

import com.github.blackchronos.foodspect_back.exception.AbstractMonoException;

public class SupplementNotFoundException extends AbstractMonoException {
    public SupplementNotFoundException(String id) {
        super("Supplement %s is not found!".formatted(id));
    }
}
