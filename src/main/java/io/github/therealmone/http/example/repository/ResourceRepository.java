package io.github.therealmone.http.example.repository;

import io.github.therealmone.http.example.entity.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, UUID> {
}
