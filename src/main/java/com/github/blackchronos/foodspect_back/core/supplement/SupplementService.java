package com.github.blackchronos.foodspect_back.core.supplement;

import com.github.blackchronos.foodspect_back.core.supplement.exception.SupplementNotFoundException;
import com.github.blackchronos.foodspect_back.core.supplement.model.Supplement;
import com.github.blackchronos.foodspect_back.core.supplement.repository.SupplementRepository;
import com.github.blackchronos.foodspect_back.emitter.besteffort.MulticastBestEffortEmitter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class SupplementService extends MulticastBestEffortEmitter<Supplement> {
    private final SupplementRepository supplementRepository;


    public Mono<Supplement> getSupplementById(String id) {
        return this.supplementRepository.findById(id)
                .switchIfEmpty(new SupplementNotFoundException(id).toMono());
    }

    public Mono<Supplement> getSupplementByCode(String code) {
        return this.supplementRepository.findByCode(code)
                .switchIfEmpty(new SupplementNotFoundException(code).toMono());
    }

    public Mono<Supplement> save(Supplement supplement) {
        return this.supplementRepository.save(supplement).map(this::emit);
    }

}
