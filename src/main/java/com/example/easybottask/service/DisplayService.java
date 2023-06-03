package com.example.easybottask.service;

import com.example.easybottask.exception.ArgumentException;
import com.example.easybottask.model.Display;
import com.example.easybottask.repository.DisplayRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DisplayService {
    private final DisplayRepository displayRepository;

    public Display addDisplay(Display display) throws ArgumentException {
        log.info("IN addDisplay: {} added successfully", display);
        return displayRepository.save(display);

    }

    public Display updateDisplay(Long id, Display display) throws ArgumentException {
        Display result = getDisplay(id);
        result.setSerialNumber(display.getSerialNumber());
        result.setManufacturer(display.getManufacturer());
        result.setPrice(display.getPrice());
        result.setQuantity(display.getQuantity());
        result.setSize(display.getSize());
        log.info("IN update display - display with id {} was updated", id);
        return displayRepository.save(result);
    }

    public List<Display> getAllDisplays() {
        List<Display> result = displayRepository.findAll();
        log.info("IN getAllDisplay - {} displays were found", result.size());
        return result;
    }

    public Display getDisplay(Long id) {
        Display result = displayRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN getDisplay - no display was found by id: {}", id);
        } else {
            log.info("IN getDisplay - display by id: {} was found", result);
        }
        return result;
    }
}
