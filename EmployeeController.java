package com.qsp.springboot_employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_employee_management.dao.EmployeeDao;
import com.qsp.springboot_employee_management.dto.Employee;
import com.qsp.springboot_employee_management.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
	private EmployeeDao dao;
    @Autowired
    private EmployeeService service;
	@PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee e) {
    	return service.saveEmployee(e);
    }
	@GetMapping("/fetch")
	public Employee fetchEmployee(int id) {
		return service.fetchEmployee(id);
	}
	@DeleteMapping("/delete/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
	@PatchMapping("updateEmployee")
	public Employee updateEmployee(@RequestParam int id,@RequestBody Employee e) {
		return service.updateEmployee(id, e);
	}
	@PostMapping("/saveall")
	public List<Employee> saveAll(@RequestBody List<Employee>list){
		return service.saveAll(list);
	}
	@PatchMapping("/updatephone")
	public Employee updatePhone(int id,long phone) {
		return service.updatePhone(id,phone);
	}
	@PatchMapping("/updateemail")
	public Employee udateEmail(int id,String email) {
		return dao.updateEmail(id,email);
	}
	@PatchMapping("updatesalary")
	public Employee updateSalary(int id,double salary) {
		return service.updateSalary(id,salary);
	}
	@GetMapping("findbyphone")
	public Employee findByPhone(long phone) {
		return dao.findEmployeeByPhone(phone);
	}
	@GetMapping("getbyemail")
	public Employee getEmployeeByEmail(String email) {
		return dao.getEmployeeByeEmail(email);
	}
	@GetMapping("findbyaddress")
	public List<Employee> findEmployeeByAddress(String address){
		return dao.findEmployeeByAddress(address);
	}
	@GetMapping("getsalary")
	public Employee getEmployeeBySalary(double salary){
		return dao.getEmployeeBySalary(salary);
	}
	@GetMapping("/salarylessthan")
	public List<Employee> salaryLessThan(double salary){
		return dao.salaryLessThan(salary);
	}
	@GetMapping("/salbetween")
	public List<Employee> salaryBetween(double salary1,double salary2){
		return dao.salaryBetween(salary1, salary2);
	}
}
