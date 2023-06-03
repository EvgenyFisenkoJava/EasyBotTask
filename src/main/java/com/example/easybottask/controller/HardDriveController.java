package com.example.easybottask.controller;

import com.example.easybottask.model.HardDrive;
import com.example.easybottask.service.HardDriveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/hd")
public class HardDriveController {

    private final HardDriveService hardDriveService;

    @PostMapping("/add")
    public ResponseEntity<HardDrive> addHardDrive(@RequestBody @Valid HardDrive hardDrive) {
        return ResponseEntity.ok(hardDriveService.addHardDrive(hardDrive));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardDrive> editHardDrive(@RequestParam Long id, @RequestBody @Valid HardDrive hardDrive) {
        return ResponseEntity.ok(hardDriveService.updateHardDrive(id, hardDrive));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDrive> getById(@RequestParam Long id) {
        return ResponseEntity.ok(hardDriveService.getHardDrive(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<HardDrive>> getAllHardDrive() {
        return ResponseEntity.ok(hardDriveService.getAllHardDrives());
    }
}
