package com.qsp.springboot_employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.springboot_employee_management.dao.EmployeeDao;
import com.qsp.springboot_employee_management.dto.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
  public Employee saveEmployee(Employee e) {
	  double sal=e.getSalary();
	  if(sal<10000) {
		  e.setGrade("d");
	  }else if(sal>=10000 && sal<=15000) {
		  e.setGrade("c");
		  }else if(sal>=15000 && sal<=20000) {
			  e.setGrade("b");
		  }else {
			  e.setGrade("A");
		  }
	  return dao.saveEmployee(e);
  }
  public Employee fetchEmployee(int id) {
	  return dao.fetchEmployee(id);
  }
  public Employee deleteEmployee(int id) {
	  Employee e=dao.fetchEmployee(id);
	  if(e!=null) {
		  return dao.deleteEmployee(e);
	  }
	  return null;
  }
  public Employee updateEmployee(int id,Employee e) {
	  Employee dbe=dao.fetchEmployee(id);
	  if(dbe!=null) {
		  e.setId(id);
		  return saveEmployee(e);
	  }
	return null;
  }
public List<Employee> saveAll(List<Employee> list) {
	for(Employee e:list) {
		double sal=e.getSalary();
		  if(sal<10000) {
			  e.setGrade("d");
		  }else if(sal>=10000 && sal<=15000) {
			  e.setGrade("c");
			  }else if(sal>=15000 && sal<=20000) {
				  e.setGrade("b");
			  }else {
				  e.setGrade("A");
			  }
		
	}
	return list;

}
public Employee updatePhone(int id, long phone) {
	 
	Employee e=dao.fetchEmployee(id);
	if(e!=null) {
		e.setPhone(phone);
		return dao.saveEmployee(e);
	}
	return null;
}
public Employee updateSalary(int id, double salary) {
	 Employee dbe=dao.fetchEmployee(id);
	  if(dbe!=null) {
		  dbe.setSalary(salary);
		  return saveEmployee(dbe);
	  }
	return null; 
	
}

   
}
