package com.example.easybottask.service;

import com.example.easybottask.exception.ArgumentException;
import com.example.easybottask.model.PC;
import com.example.easybottask.repository.PCRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PCService {

    private final PCRepository pcRepository;

    public PC addPC(PC pc) throws ArgumentException {
        if (!validType(pc)) {
            log.warn("IN addPC : type {} is wrong. Only DESKTOP, MONOBLOCK or NETTOP are allowed", pc.getType());
            throw new ArgumentException("Field 'type' can only be DESKTOP, MONOBLOCK or NETTOP");
        } else {
            log.info("IN addPC: {} added successfully", pc);
            return pcRepository.save(pc);
        }
    }

    public PC updatePC(Long id, PC pc) throws ArgumentException {

        PC result = getPC(id);

        if (!validType(pc)) {
            log.warn("IN updatePC: type {} is wrong. Only DESKTOP, MONOBLOCK or NETTOP are allowed", pc.getType());
            throw new ArgumentException("Field 'type' can only be DESKTOP, MONOBLOCK or NETTOP");
        }
        result.setSerialNumber(pc.getSerialNumber());
        result.setManufacturer(pc.getManufacturer());
        result.setPrice(pc.getPrice());
        result.setQuantity(pc.getQuantity());
        result.setType(pc.getType());
        log.info("IN updatePC - pc with id {} was updated", id);
        return pcRepository.save(result);
    }

    public List<PC> getAllPC() {
        List<PC> result = pcRepository.findAll();
        log.info("IN getAllPc - {} pc were found", result.size());
        return result;
    }

    public PC getPC(Long id) {
        PC result = pcRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN getPc - no pc was found by id: {}", id);
        } else {
            log.info("IN getPc - pc by id: {} was found", result);
        }
        return result;
    }

    private boolean validType(PC pc) {
        return pc.getType().equals("DESKTOP")
                || pc.getType().equals("NETTOP")
                || pc.getType().equals("MONOBLOCK");
    }


}
