package com.github.blackchronos.foodspect_back.core.supplement.repository;

import com.github.blackchronos.foodspect_back.core.supplement.model.Supplement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SupplementRepository extends ReactiveMongoRepository<Supplement, String> {

    Mono<Supplement> findByCode(String code);
}
