package io.github.therealmone.http.example.service;

import io.github.therealmone.http.example.dto.CreateResourceRequest;
import io.github.therealmone.http.example.dto.ResourceDto;
import io.github.therealmone.http.example.dto.UpdateResourceRequest;

import java.util.List;
import java.util.UUID;

public interface HttpExampleService {

    List<ResourceDto> getResources();

    ResourceDto getResourceById(UUID id);

    void createResource(CreateResourceRequest request);

    void updateResource(UUID id, UpdateResourceRequest request);
}
