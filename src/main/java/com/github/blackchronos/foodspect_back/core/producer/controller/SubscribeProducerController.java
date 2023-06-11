package com.github.blackchronos.foodspect_back.core.producer.controller;

import com.github.blackchronos.foodspect_back.core.producer.ProducerService;
import com.github.blackchronos.foodspect_back.core.producer.model.Producer;
import com.github.blackchronos.foodspect_back.core.producer.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class SubscribeProducerController {
    private final ProducerService producerService;
    private final ProducerRepository producerRepository;

    @MessageMapping("subscribeProducer")
    public Flux<Producer> subscribeProducer(@RequestBody SubscribeProducerRequest request) {
        System.out.println("hi there");
        return this.producerService.getFlux()
                .filter(producer -> producer.id.equals(request.producerId))
                .mergeWith(this.producerRepository.findById(request.producerId));
    }

    public record SubscribeProducerRequest(String producerId) {}
}
