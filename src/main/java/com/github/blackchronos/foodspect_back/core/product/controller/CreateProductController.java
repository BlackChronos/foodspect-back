package com.github.blackchronos.foodspect_back.core.product.controller;


import com.github.blackchronos.foodspect_back.core.producer.repository.ProducerRepository;
import com.github.blackchronos.foodspect_back.core.product.ProductService;
import com.github.blackchronos.foodspect_back.core.product.model.Category;
import com.github.blackchronos.foodspect_back.core.product.model.Nutrition;
import com.github.blackchronos.foodspect_back.core.product.model.Product;
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
public class CreateProductController {
    private final ProductService productService;
    private final ProducerRepository producerRepository;


    @MessageMapping("createProduct")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public Mono<Void> createProduct(@RequestBody CreateProductRequest request) {
        this.productService.save(Product.builder()
                        .name(request.name)
                        .description(request.description)
                        .supplements(request.supplements)
                        .nutrition(request.nutrition)
                        .producer(request.producer)
                        .photoLink(request.photoLink)
                        .category(request.category).build())
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe();
        return Mono.empty();

    }

    public record CreateProductRequest(
            String name,
            String description,

            String producer,
            Nutrition nutrition,
            Supplement[] supplements,
            Category[] category,

            String photoLink
    ) {
    }
}
