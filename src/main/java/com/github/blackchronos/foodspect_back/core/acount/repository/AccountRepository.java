package com.github.blackchronos.foodspect_back.core.acount.repository;

import com.github.blackchronos.foodspect_back.core.acount.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, Long> {
    Mono<Account> findByUsername(String username);

    Mono<Boolean> existsByUsernameEqualsIgnoreCase(String username);
}
