package io.github.therealmone.http.example.controller;

import io.github.therealmone.http.example.dto.CreateResourceRequest;
import io.github.therealmone.http.example.dto.Resource;
import io.github.therealmone.http.example.service.HttpExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final HttpExampleService service;

    @GetMapping("/resource")
    public Resource getResource() {
        return service.getResource();
    }

    @GetMapping("/resource/{id}")
    public Resource getResourceWithParams(@PathVariable("id") UUID id,
                                          @RequestParam("name") String name) {
        return service.getResource(name, id);
    }

    @PostMapping("/resource")
    public void createResource(@RequestBody CreateResourceRequest request) {
        service.createResource(request);
    }

    @PutMapping("/resource/{id}")
    public void updateResource(@PathVariable("id") UUID id) {
        service.updateResource(id);
    }

}
