package com.example.easybottask.controller;

import com.example.easybottask.model.PC;
import com.example.easybottask.service.PCService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/pc")
public class PCController {

    private final PCService pcService;

    @PostMapping("/add")
    public ResponseEntity<PC> addPC(@RequestBody @Valid PC pc) {
        return ResponseEntity.ok(pcService.addPC(pc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PC> editPC(@RequestParam Long id, @RequestBody @Valid PC pc) {
        return ResponseEntity.ok(pcService.updatePC(id, pc));
    }

    @GetMapping()
    public ResponseEntity<PC> getById(@RequestParam Long id) {
        return ResponseEntity.ok(pcService.getPC(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PC>> getAllPC() {
        return ResponseEntity.ok(pcService.getAllPC());
    }
}
