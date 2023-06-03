package com.example.easybottask.controller;

import com.example.easybottask.model.Display;
import com.example.easybottask.service.DisplayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/display")
public class DisplayController {

    private final DisplayService displayService;

    @PostMapping("/add")
    public ResponseEntity<Display> addDisplay(@RequestBody @Valid Display display) {
        return ResponseEntity.ok(displayService.addDisplay(display));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Display> editDisplay(@RequestParam Long id, @RequestBody @Valid Display display) {
        return ResponseEntity.ok(displayService.updateDisplay(id, display));
    }

    @GetMapping()
    public ResponseEntity<Display> getById(@RequestParam Long id) {
        return ResponseEntity.ok(displayService.getDisplay(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Display>> getAllDisplay() {
        return ResponseEntity.ok(displayService.getAllDisplays());
    }
}
