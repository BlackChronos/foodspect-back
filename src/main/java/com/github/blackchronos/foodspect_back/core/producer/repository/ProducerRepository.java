package com.github.blackchronos.foodspect_back.core.producer.repository;

import com.github.blackchronos.foodspect_back.core.producer.model.Producer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends ReactiveMongoRepository<Producer, String> {

}