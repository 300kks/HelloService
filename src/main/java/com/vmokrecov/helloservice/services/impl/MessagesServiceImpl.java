package com.vmokrecov.helloservice.services.impl;

import com.vmokrecov.helloservice.dto.MessagesDTO;
import com.vmokrecov.helloservice.repositories.MessagesRepository;
import com.vmokrecov.helloservice.services.MessagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MessagesServiceImpl implements MessagesService {

    private final MessagesRepository repository;

    @Override
    public Mono<MessagesDTO> getMessage(Long id) {
        return repository.findById(id).map(messages -> new MessagesDTO(messages.getMessage()));
    }

    @Override
    public Flux<MessagesDTO> getAllMessages() {
        return repository.findAll().map(messages -> new MessagesDTO(messages.getMessage()));
    }
}
