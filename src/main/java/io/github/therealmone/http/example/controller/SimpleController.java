package io.github.therealmone.http.example.controller;

import io.github.therealmone.http.example.dto.CreateResourceRequest;
import io.github.therealmone.http.example.dto.ResourceDto;
import io.github.therealmone.http.example.dto.UpdateResourceRequest;
import io.github.therealmone.http.example.service.HttpExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final HttpExampleService service;

    @GetMapping("/resource")
    public List<ResourceDto> getResources() {
        return service.getResources();
    }

    @GetMapping("/resource/{id}")
    public ResourceDto getResourceById(@PathVariable("id") UUID id) {
        return service.getResourceById(id);
    }

    @PostMapping("/resource")
    public void createResource(@RequestBody CreateResourceRequest request) {
        service.createResource(request);
    }

    @PutMapping("/resource/{id}")
    public void updateResource(@PathVariable("id") UUID id,
                               @RequestBody UpdateResourceRequest request) {
        service.updateResource(id, request);
    }

}
