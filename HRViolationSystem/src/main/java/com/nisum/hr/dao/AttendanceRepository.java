package com.nisum.hr.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.nisum.hr.models.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer>{
	
	
	
}