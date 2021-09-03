package io.github.therealmone.http.example.service.impl;

import io.github.therealmone.http.example.dto.CreateResourceRequest;
import io.github.therealmone.http.example.dto.Resource;
import io.github.therealmone.http.example.service.HttpExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class HttpExampleServiceImpl implements HttpExampleService {

    @Override
    public Resource getResource() {
        log.info("Get default resource");

        return Resource.builder()
                .name("Default name")
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public Resource getResource(String name, UUID id) {
        log.info("Get resource: {}, {}", name, id);

        return Resource.builder()
                .name(name)
                .id(id)
                .build();
    }

    @Override
    public void createResource(CreateResourceRequest request) {
        log.info("Create resource: {}", request);
    }

    @Override
    public void updateResource(UUID id) {
        log.info("Update resource: {}", id);
    }

}
