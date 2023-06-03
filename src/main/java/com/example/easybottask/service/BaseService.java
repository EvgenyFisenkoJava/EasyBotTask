package com.example.easybottask.service;

import com.example.easybottask.exception.MyArgumentException;
import com.example.easybottask.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Slf4j
public abstract class BaseService<T extends BaseEntity> {

    protected final JpaRepository<T, Long> repository;

    public BaseService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T add(T entity) throws MyArgumentException {
        log.info("IN add: {} added successfully", entity);
        return repository.save(entity);
    }

    public T update(Long id, T entity) throws MyArgumentException {
        T result = get(id);
        result.setSerialNumber(entity.getSerialNumber());
        result.setManufacturer(entity.getManufacturer());
        result.setPrice(entity.getPrice());
        result.setQuantity(entity.getQuantity());
        log.info("IN update - entity with id {} was updated", id);
        return repository.save(result);
    }

    public List<T> getAll() {
        List<T> result = repository.findAll();
        log.info("IN getAll - {} entities were found", result.size());
        return result;
    }

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
