package com.example.leave_management.controller;

import com.example.leave_management.model.LeaveRequest;
import com.example.leave_management.repository.LeaveRequestRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    // POST /leaves → Create leave request
    @PostMapping
    public ResponseEntity<?> createLeave(@Valid @RequestBody LeaveRequest leaveRequest) {
        // Validation: endDate must not be before startDate
        if (leaveRequest.getEndDate().isBefore(leaveRequest.getStartDate())) {
            return ResponseEntity.badRequest().body("End date cannot be before start date.");
        }
        LeaveRequest savedLeave = leaveRequestRepository.save(leaveRequest);
        return ResponseEntity.ok(savedLeave);
    }

    // GET /leaves → Get all leave requests
    @GetMapping
    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestRepository.findAll();
    }

    // GET /leaves/{id} → Get one leave request
    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveById(@PathVariable Long id) {
        return leaveRequestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /leaves/employee/{employeeId} → Get leaves for an employee
    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeavesByEmployee(@PathVariable Long employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }

    // PUT /leaves/{id}/status → Approve/Reject a leave request
    @PutMapping("/{id}/status")
    public ResponseEntity<LeaveRequest> updateLeaveStatus(@PathVariable Long id,
                                                          @RequestParam LeaveRequest.Status status) {
        return leaveRequestRepository.findById(id)
                .map(leave -> {
                    leave.setStatus(status);
                    leaveRequestRepository.save(leave);
                    return ResponseEntity.ok(leave);
                }).orElse(ResponseEntity.notFound().build());
    }
}
