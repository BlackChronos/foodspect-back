package com.github.blackchronos.foodspect_back.core.product.repository;

import com.github.blackchronos.foodspect_back.core.product.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    Flux<Product> getProductsByProducer(String producerId);
}
