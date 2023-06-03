package com.example.easybottask.service;

import com.example.easybottask.exception.MyArgumentException;
import com.example.easybottask.model.HardDrive;
import com.example.easybottask.repository.HardDriveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardDriveService extends BaseService<HardDrive> {
    public HardDriveService(HardDriveRepository hardDriveRepository) {
        super(hardDriveRepository);
    }

    public HardDrive addHardDrive(HardDrive hardDrive) throws MyArgumentException {
        return super.add(hardDrive);
    }

    public HardDrive updateHardDrive(Long id, HardDrive hardDrive) throws MyArgumentException {
        HardDrive result = getHardDrive(id);
        result.setVolume(hardDrive.getVolume());
        return super.update(id, hardDrive);
    }

    public List<HardDrive> getAllHardDrives() {
        return super.getAll();
    }

    public HardDrive getHardDrive(Long id) {
        return super.get(id);
    }
}
