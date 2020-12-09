package com.repairService.repairService.controller;

import com.repairService.repairService.repository.StatusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    private final StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @GetMapping("/api/v1/statuses")
    public ResponseEntity<Object> getAllStatuses() {
        return ResponseEntity.status(HttpStatus.OK).body(statusRepository.getAllStatuses());
    }
}
