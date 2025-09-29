package com.example.leave_management.service;

import com.example.leave_management.model.LeaveRequest;
import com.example.leave_management.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    // Get all leave requests
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // Get a leave request by ID
    public Optional<LeaveRequest> getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    // Create a new leave request
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    // Update an existing leave request
    public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequestDetails) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found with id " + id));

        leaveRequest.setStartDate(leaveRequestDetails.getStartDate());
        leaveRequest.setEndDate(leaveRequestDetails.getEndDate());
        leaveRequest.setReason(leaveRequestDetails.getReason());
        leaveRequest.setStatus(leaveRequestDetails.getStatus());

        return leaveRequestRepository.save(leaveRequest);
    }

    // Delete a leave request
    public void deleteLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave Request not found with id " + id));
        leaveRequestRepository.delete(leaveRequest);
    }
}
