package io.github.therealmone.http.example.service;

import io.github.therealmone.http.example.dto.CreateResourceRequest;
import io.github.therealmone.http.example.dto.Resource;

import java.util.UUID;

public interface HttpExampleService {

    Resource getResource();

    Resource getResource(String name, UUID id);

    void createResource(CreateResourceRequest request);

    void updateResource(UUID id);
}
