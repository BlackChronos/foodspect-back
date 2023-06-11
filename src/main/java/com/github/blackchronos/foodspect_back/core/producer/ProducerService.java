package com.github.blackchronos.foodspect_back.core.producer;


import com.github.blackchronos.foodspect_back.core.producer.model.Producer;
import com.github.blackchronos.foodspect_back.core.producer.repository.ProducerRepository;
import com.github.blackchronos.foodspect_back.emitter.besteffort.MulticastBestEffortEmitter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProducerService extends MulticastBestEffortEmitter<Producer> {
    private final ProducerRepository producerRepository;

    public Mono<Producer> save(Producer producer){
        return this.producerRepository.save(producer).map(this::emit);
    }

}
