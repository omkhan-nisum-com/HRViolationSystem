package com.nisum.hr.dao;

import org.springframework.data.repository.CrudRepository;

import com.nisum.hr.models.Employees;

public interface EmployeeRepository extends CrudRepository<Employees, Integer>{

}
