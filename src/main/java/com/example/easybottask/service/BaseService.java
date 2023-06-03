package com.example.easybottask.service;

import com.example.easybottask.exception.MyArgumentException;
import com.example.easybottask.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Base service class that provides basic CRUD operations for entities
 * @param <T> The type of entity that this service manages, which extends BaseEntity
 */
@Slf4j
public abstract class BaseService<T extends BaseEntity> {

    protected final JpaRepository<T, Long> repository;

    public BaseService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }
    
    /**
     * Adds a new entity to the repository
     * @param entity The entity to add
     * @return The added entity
     * @throws MyArgumentException if a parameter is invalid
     */
    public T add(T entity) throws MyArgumentException {
        log.info("IN add: {} added successfully", entity);
        return repository.save(entity);
    }
    
    /**
     * Updates an existing entity in the repository
     * @param id The ID of the entity to update
     * @param entity The new entity data
     * @return The updated entity
     * @throws MyArgumentException if a parameter is invalid or the ID does not exist
     */
    public T update(Long id, T entity) throws MyArgumentException {
        T result = get(id);
        result.setSerialNumber(entity.getSerialNumber());
        result.setManufacturer(entity.getManufacturer());
        result.setPrice(entity.getPrice());
        result.setQuantity(entity.getQuantity());
        log.info("IN update - entity with id {} was updated", id);
        return repository.save(result);
    }
    
    /**
     * Retrieves all entities from the repository
     * @return A list of all entities
     */
    public List<T> getAll() {
        List<T> result = repository.findAll();
        log.info("IN getAll - {} entities were found", result.size());
        return result;
    }
    
    /**
     * Retrieves an entity with the given ID from the repository
     * @param id The ID of the entity to retrieve
     * @return The retrieved entity, or null if no such entity exists
     */
    public T get(Long id) {
        T result = repository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN get - no entity was found by id: {}", id);
        } else {
            log.info("IN get - entity by id: {} was found", result);
        }
        return result;
    }
}
