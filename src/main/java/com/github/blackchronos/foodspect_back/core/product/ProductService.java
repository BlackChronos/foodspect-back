package com.github.blackchronos.foodspect_back.core.product;

import com.github.blackchronos.foodspect_back.core.product.model.Product;
import com.github.blackchronos.foodspect_back.core.product.repository.ProductRepository;
import com.github.blackchronos.foodspect_back.emitter.besteffort.MulticastBestEffortEmitter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class ProductService extends MulticastBestEffortEmitter<Product> {
    private final ProductRepository productRepository;

    public Mono<Product> save(Product product){
        return this.productRepository.save(product).map(this::emit);
    }

}
