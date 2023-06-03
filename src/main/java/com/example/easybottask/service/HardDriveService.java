package com.example.easybottask.service;

import com.example.easybottask.exception.ArgumentException;
import com.example.easybottask.model.HardDrive;
import com.example.easybottask.repository.HardDriveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HardDriveService {
    private final HardDriveRepository hardDriveRepository;

    public HardDrive addHardDrive(HardDrive hardDrive) throws ArgumentException {
        log.info("IN addHardDrive: {} added successfully", hardDrive);
        return hardDriveRepository.save(hardDrive);

    }

    public HardDrive updateHardDrive(Long id, HardDrive hardDrive) throws ArgumentException {
        HardDrive result = getHardDrive(id);
        result.setSerialNumber(hardDrive.getSerialNumber());
        result.setManufacturer(hardDrive.getManufacturer());
        result.setPrice(hardDrive.getPrice());
        result.setQuantity(hardDrive.getQuantity());
        result.setVolume(hardDrive.getVolume());
        log.info("IN update hardDrive - hardDrive with id {} was updated", id);
        return hardDriveRepository.save(result);
    }

    public List<HardDrive> getAllHardDrives() {
        List<HardDrive> result = hardDriveRepository.findAll();
        log.info("IN getAllHardDrive - {} hardDrives were found", result.size());
        return result;
    }

    public HardDrive getHardDrive(Long id) {
        HardDrive result = hardDriveRepository.findById(id).orElse(null);
        if (result == null) {
            log.warn("IN getHardDrive - no hardDrive was found by id: {}", id);
        } else {
            log.info("IN getHardDrive - hardDrive by id: {} was found", result);
        }
        return result;
    }
}
