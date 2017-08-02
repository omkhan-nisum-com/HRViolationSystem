package com.nisum.hr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.hr.dao.EmployeeRepository;
import com.nisum.hr.models.*;



@Service
@Transactional
public class EmployeeService {
	
	private EmployeeRepository employeeRepo;
	
	@Autowired 
	private RolesService rolesService;
	
	
	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo=employeeRepo;
	}
	
	
	public Employees getEmployeeById(int id) {
		
		Employees employee = employeeRepo.findOne(id);
		return employee;
	}
	
	public List<Employees> findAll(){
		
		List<Employees> employees =  new ArrayList<Employees>();
		for(Employees employee : employeeRepo.findAll()) {
			
			employees.add(employee);
		}
		
		
		
		return employees;
	}
	
	public void save(Employees employee) {
		
		if(employee.getId()==0) { //i.e. a new employee
			/*
			Set<Task> tasksList = new HashSet<Task>();
			
			Task t = new Task("Dummy 1", "Dummy 1 DESC", new Date(), true);
			Task t1 = new Task("Dummy 2", "Dummy 2 DESC", new Date(), false);
			
			t1.setCustomer(employee);
			t.setCustomer(employee);
			
			
			tasksList.add(t);
			tasksList.add(t1);
			
			employee.setTasksList(tasksList);
			
			*/
			
//			Set<Roles> rolesSet = new HashSet<Roles>();
			//.addAll(rolesList);
			//employee.setCustomerRoles(rolesSet);
			
		}
		else { //i.e. old employee
			
			//employee.getCustomerRoles().clear();
			
		}
		
		employeeRepo.save(employee);
	}
	
	public void delete(Employees employee) {
		
		employeeRepo.delete(employee);
	}

	public void delete(int taskId) {
		
		employeeRepo.delete(taskId);
	}

}
