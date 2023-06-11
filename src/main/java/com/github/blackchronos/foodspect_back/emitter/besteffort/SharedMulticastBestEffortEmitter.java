package com.github.blackchronos.foodspect_back.emitter.besteffort;

import com.github.blackchronos.foodspect_back.emitter.Emitter;
import lombok.Getter;
import reactor.core.publisher.Flux;

public abstract class SharedMulticastBestEffortEmitter<T> extends MulticastBestEffort<T> implements Emitter<T> {
    @Getter
    private final Flux<T> flux = this.getSinks().asFlux().share();
}
