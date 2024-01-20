package com.qsp.springboot_employee_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_employee_management.dto.Employee;
import com.qsp.springboot_employee_management.repo.EmployeeRepo;

@Repository//to make object of employee dao to talk with repository
public class EmployeeDao {
    @Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}
	public Employee fetchEmployee(int id) {
//		return repo.findById(id).get();//mismatch of return type so we use get method to avoid no such element exception
		Optional<Employee>o=repo.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		return null;
	}
	public List<Employee> fetchAll(int id){
		return repo.findAll();
	}
//	public Employee deleteEmployee  //(int id)
//	{
//		Optional<Employee>opt=repo.findById(id);
//		if(opt.isPresent()) {
//			repo.deleteById(id);
//			return optional.get();
		//			Employee employee=opt.get();
//			repo.delete(employee);
//			return employee;
//		}
//		return null;
//}
	public Employee deleteEmployee(Employee e) {
		repo.delete(e);
		return e;
	}
	public Employee updateEmployee(int id,Employee e) {
		Optional<Employee>opti=repo.findById(id);
		if(opti.isPresent()) {
		e.setId(id);
		return repo.save(e);
	}
		return null;
	}
	public List<Employee> saveAll(List<Employee>list){
		return repo.saveAll(list);
	}
	public Employee updatePhone(int id,long phone) {
		Optional<Employee>optional=repo.findById(id);
		if(optional.isPresent()) {
			Employee e=optional.get();
			e.setPhone(phone);
			return repo.save(e);
		}
		return null;
	}
	public Employee updateEmail(int id,String email) {
		Optional<Employee>o=repo.findById(id);
		if(o.isPresent()) {
			Employee e=o.get();
			e.setEmail(email);
			return repo.save(e);
		}
		return null;
	}
	public Employee updateSalary(int id,double salary) {
		Optional<Employee>opt=repo.findById(id);
		if(opt.isPresent()) {
			Employee e=opt.get();
			e.setSalary(salary);
			return repo.save(e);
		}
		return null;
	}
	public Employee findEmployeeByPhone(long phone) {
		return repo.findEmployeeByPhone(phone);
	}
	public Employee getEmployeeByeEmail(String email) {
		return repo.getEmployeeByEmail(email);
	}
	public List<Employee> findEmployeeByAddress(String address){
		return repo.findEmployeeByAddress(address);
	}
	public Employee getEmployeeBySalary(double salary) {
		return repo.getEmployeeBySalary(salary);
	}
	 public List<Employee> salaryLessThan(double salary){
		return repo.findEmployeeBySalaryLessThan(salary); 
	 }
	 public List<Employee>  salaryBetween(double salary1,double salary2){
		 return repo.employeeSalaryBetween(salary1, salary2);	 }
}
