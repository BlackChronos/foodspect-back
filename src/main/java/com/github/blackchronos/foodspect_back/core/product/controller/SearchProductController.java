package com.github.blackchronos.foodspect_back.core.product.controller;


import com.github.blackchronos.foodspect_back.core.product.model.Category;
import com.github.blackchronos.foodspect_back.core.product.repository.ProductRepository;
import com.github.blackchronos.foodspect_back.core.utils.IdService.IdWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class SearchProductController {
    private final ProductRepository productRepository;


    @MessageMapping("searchProducts")
    public Flux<IdWrapper<String>> searchProducts(@RequestBody SearchProductRequest request) {
        return this.productRepository.findAll()
                .filter(product -> {
                    String name = request.name;
                    Category category = request.category;
                    boolean filter = true;
                    if (name != null) {
                        filter &= product.name.contains(name);
                    }
                    if (category != null) {
                        filter &= Set.of(product.category).contains(category);
                    }
                    return filter;
                })
                .map(product -> new IdWrapper<>(product.id));
    }


    public record SearchProductRequest(String name, Category category) {
    }

}
