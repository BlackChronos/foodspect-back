package com.github.blackchronos.foodspect_back.core.producer.controller;


import com.github.blackchronos.foodspect_back.core.producer.ProducerService;
import com.github.blackchronos.foodspect_back.core.producer.model.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Controller
@RequiredArgsConstructor
public class CreateProducerController {
    private final ProducerService producerService;

    @MessageMapping("createProducer")
    public Mono<Void> createProducer(@RequestBody CreateProducerRequest request) {
        this.producerService.save(Producer.builder()
                .name(request.name)
                .address(request.address)
                .description(request.description)
                .logoLink(request.logoLink)
                .phone(request.phone)
                .build())
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe();
        return Mono.empty();
    }


    public record CreateProducerRequest(String name, String description, String phone, String address, String logoLink) {

    }
}
