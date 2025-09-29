package com.example.leave_management.validation;

import com.example.leave_management.model.LeaveRequest;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestValidator {

    public void validateDates(LeaveRequest leaveRequest) {
        if (leaveRequest.getEndDate().isBefore(leaveRequest.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }
    }
}
