package io.github.therealmone.http.example.service.impl;

import io.github.therealmone.http.example.dto.CreateResourceRequest;
import io.github.therealmone.http.example.dto.ResourceDto;
import io.github.therealmone.http.example.dto.UpdateResourceRequest;
import io.github.therealmone.http.example.entity.Resource;
import io.github.therealmone.http.example.repository.ResourceRepository;
import io.github.therealmone.http.example.service.HttpExampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class HttpExampleServiceImpl implements HttpExampleService {

    private final ResourceRepository resourceRepository;

    @Override
    public List<ResourceDto> getResources() {
        log.info("Get default resource");

        return StreamSupport.stream(resourceRepository.findAll().spliterator(), false)
                .map(resource -> ResourceDto.builder()
                        .name(resource.getName())
                        .id(resource.getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ResourceDto getResourceById(UUID id) {
        log.info("Get resource: {}", id);

        val resource = resourceRepository.findById(id);

        if (resource.isPresent()) {
            return ResourceDto.builder()
                    .name(resource.get().getName())
                    .id(resource.get().getId())
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }
    }

    @Override
    public void createResource(CreateResourceRequest request) {
        log.info("Create resource: {}", request);

        val resource = Resource.builder()
                .name(request.getName())
                .build();

        resourceRepository.save(resource);
    }

    @Override
    public void updateResource(UUID id, UpdateResourceRequest request) {
        log.info("Update resource: {}", id);

        val resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        resource.setName(request.getName());

        resourceRepository.save(resource);
    }

}
