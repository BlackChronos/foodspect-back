package com.github.blackchronos.foodspect_back.core.supplement.controller;

import com.github.blackchronos.foodspect_back.core.supplement.SupplementService;
import com.github.blackchronos.foodspect_back.core.supplement.model.Supplement;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Controller
@RequiredArgsConstructor
public class CreateSupplementController {
    private final SupplementService supplementService;

    @MessageMapping("searchSupplementById")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public Mono<Void> createSupplement(@RequestBody CreateSupplementRequest request) {
        this.supplementService.save(Supplement.builder()
                        .name(request.name)
                        .description(request.description)
                        .code(request.code)
                        .rating(request.rating)
                        .build())
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe();
        return Mono.empty();
    }

    public record CreateSupplementRequest(String name, String code, String description, int rating) {
    }

}
