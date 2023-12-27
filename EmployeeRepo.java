package com.qsp.springboot_employee_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_employee_management.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
