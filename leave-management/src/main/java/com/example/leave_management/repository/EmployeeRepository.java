package com.example.leave_management.repository;

import com.example.leave_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Optional: Add custom query methods if needed
}
