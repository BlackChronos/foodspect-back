package com.github.blackchronos.foodspect_back.core.supplement.controller;


import com.github.blackchronos.foodspect_back.core.supplement.SupplementService;
import com.github.blackchronos.foodspect_back.core.supplement.model.Supplement;
import com.github.blackchronos.foodspect_back.core.supplement.repository.SupplementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Controller
@RequiredArgsConstructor
public class SearchSupplementController {
    private final SupplementService supplementService;
    private final SupplementRepository supplementRepository;

    @MessageMapping("searchSupplementById")
    public Mono<Supplement> getSupplementById(String id) {
        return this.supplementService.getSupplementById(id);
    }

    @MessageMapping("searchSupplementByCode")
    public Mono<Supplement> getSupplementByCode(String code) {
        return this.supplementService.getSupplementByCode(code);
    }

    @MessageMapping("searchAllSupplements")
    public Flux<Supplement> getAllSupplements() {
        return this.supplementRepository.findAll()
                .sort(Comparator.comparing(sup -> sup.code));
    }

}
