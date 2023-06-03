package com.example.easybottask.service;

import com.example.easybottask.exception.ArgumentException;
import com.example.easybottask.model.Laptop;
import com.example.easybottask.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public Laptop addLaptop(Laptop laptop) throws ArgumentException {
        if (!validSize(laptop)) {
            log.warn("IN addLaptop: the size {} inches is wrong. Only 13, 14, 15 or 17 allowed ", laptop.getSize());
            throw new ArgumentException("The size should be 13, 14, 15 or 17");
        }
        log.info("IN addLaptop: {} added successfully", laptop);
        return laptopRepository.save(laptop);

    }

    public Laptop updateLaptop(Long id, Laptop laptop) throws ArgumentException {
        Laptop result = getLaptop(id);
        if (!validSize(laptop)) {
            log.warn("IN updateLaptop: the size {} inches is wrong. Only 13, 14, 15 or 17 allowed ", laptop.getSize());
            throw new ArgumentException("The size should be 13, 14, 15 or 17");
        }
        result.setSerialNumber(laptop.getSerialNumber());
        result.setManufacturer(laptop.getManufacturer());
        result.setPrice(laptop.getPrice());
        result.setQuantity(laptop.getQuantity());
        result.setSize(laptop.getSize());
        log.info("IN update laptop - laptop with id {} was updated", id);
        return laptopRepository.save(result);
    }

    public List<Laptop> getAllLaptops() {
        List<Laptop> result = laptopRepository.findAll();
        log.info("IN getAllLaptop - {} laptops were found", result.size());
        return result;
    }

    public Laptop getLaptop(Long id) {
        Laptop result = laptopRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN getLaptop - no laptop was found by id: {}", id);
        } else {
            log.info("IN getLaptop - laptop by id: {} was found", result);
        }
        return result;
    }

    private boolean validSize(Laptop laptop) {
        return laptop.getSize() == 13
                || laptop.getSize() == 14
                || laptop.getSize() == 15
                || laptop.getSize() == 17;
    }

}

