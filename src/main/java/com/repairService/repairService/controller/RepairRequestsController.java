package com.repairService.repairService.controller;

import com.repairService.repairService.mapper.RepairRequestMapper;
import com.repairService.repairService.model.RepairRequest;
import com.repairService.repairService.repository.RepairRequestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RepairRequestsController {
    private final RepairRequestRepository repairRequestRepository;


    public RepairRequestsController(RepairRequestRepository repairRequestRepository) {
        this.repairRequestRepository = repairRequestRepository;
    }

    @PostMapping("/api/v1/repair_request")
    public ResponseEntity<Object> interceptRepairRequest(@RequestParam("repairRequest") String repairRequestJSON) {
        RepairRequest request = repairRequestRepository.setNewRequest(RepairRequestMapper.mapJSON(repairRequestJSON));
        if (request != null) {
            return ResponseEntity.status(HttpStatus.OK).body(request);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/api/v1/repair_request/status")
    public ResponseEntity<Object> setRepairRequestStatus(@RequestParam("repairRequest") String repairRequestJSON) {

        RepairRequest request = repairRequestRepository.setNewStatus(RepairRequestMapper.mapJSON(repairRequestJSON));
        if (request != null) {
            return ResponseEntity.status(HttpStatus.OK).body(request);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/api/v1/repair_request")
    public ResponseEntity<Object> getRepairRequests() {
        List<RepairRequest> requests = repairRequestRepository.getAllRepairRequests();
        if (!requests.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(requests);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/api/v1/repair_request/complete")
    public ResponseEntity<Object> getRepairRequestsComplete() {
        List<RepairRequest> requests = repairRequestRepository.getAllComplete();
        if (!requests.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(requests);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/api/v1/repair_request/in_work")
    public ResponseEntity<Object> getRepairRequestsInWork() {
        List<RepairRequest> requests = repairRequestRepository.getAllInWork();
        if (!requests.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(requests);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
