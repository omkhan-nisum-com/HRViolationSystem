package com.nisum.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.hr.service.EmployeeService;

@RestController
public class MainControllerREST {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public String helloWorld() {
		
		return "Hello World!!!! HRRRRR";
	}
	
	
	@GetMapping("/allEmployees")
	public String getAllEmployees() {
		
		return employeeService.findAll().toString();
		
		//return "";
	}
}
