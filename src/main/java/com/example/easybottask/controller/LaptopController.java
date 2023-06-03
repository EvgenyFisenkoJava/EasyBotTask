package com.example.easybottask.controller;

import com.example.easybottask.model.Laptop;
import com.example.easybottask.service.LaptopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/laptop")
public class LaptopController {

    private final LaptopService laptopService;

    @PostMapping("/add")
    public ResponseEntity<Laptop> addLaptop(@RequestBody @Valid Laptop laptop) {
        return ResponseEntity.ok(laptopService.addLaptop(laptop));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> editLaptop(@RequestParam Long id, @RequestBody @Valid Laptop laptop) {
        return ResponseEntity.ok(laptopService.updateLaptop(id, laptop));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getById(@RequestParam Long id) {
        return ResponseEntity.ok(laptopService.getLaptop(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Laptop>> getAllLaptop() {
        return ResponseEntity.ok(laptopService.getAllLaptops());
    }
}
