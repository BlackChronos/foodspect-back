package com.github.blackchronos.foodspect_back.core.producer.controller;

import com.github.blackchronos.foodspect_back.core.producer.model.Producer;
import com.github.blackchronos.foodspect_back.core.producer.repository.ProducerRepository;
import com.github.blackchronos.foodspect_back.core.product.model.Product;
import com.github.blackchronos.foodspect_back.core.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class SearchProducerController {
    private final ProducerRepository producerRepository;
    private final ProductRepository productRepository;

    @MessageMapping("searchProducers")
    public Flux<SearchProducersResponse> searchProducers(@RequestBody SearchProducersRequest request) {
        System.out.println(request.productId);
        Flux<Producer> producers = producerRepository.findAll();
        if (request.productId != null && request.productId.length() != 0)
            producers = producers.filter(producer ->
                    Objects.equals(productRepository.findAll().map(Product::getProducer), request.productId));

        return producers.map(producer -> new SearchProducersResponse(producer.id));
    }

    public record SearchProducersRequest(String productId) {
    }

    public record SearchProducersResponse(String producerId) {
    }

}