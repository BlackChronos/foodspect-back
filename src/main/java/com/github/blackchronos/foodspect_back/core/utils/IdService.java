package com.github.blackchronos.foodspect_back.core.utils;

import java.util.UUID;

import static java.lang.Math.abs;

public class IdService {
    public static String getRandomIdString() {
        return Long.toString(getRandomId());
    }

    public static long getRandomId() {
        long id = abs(UUID.randomUUID().getLeastSignificantBits());
        return id  >> 10;
    }

    public record IdWrapper<T>(T id){}

}
