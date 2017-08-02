package com.nisum.hr.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nisum.hr.dao.AttendanceRepository;

import com.nisum.hr.models.*;

@Service
@Transactional
public class AttendanceService {
	
	private final AttendanceRepository attendanceRepo;

	public AttendanceService(AttendanceRepository attendanceRepo) {
		this.attendanceRepo=attendanceRepo;
	}
	
	
	public Attendance getAttendanceById(int id) {
		
		Attendance attendance = attendanceRepo.findOne(id);
		return attendance;
	}
	
	public List<Attendance> findAll(){
		
		List<Attendance> tasks =  new ArrayList<Attendance>();
		for(Attendance attendance : attendanceRepo.findAll()) {
			
			tasks.add(attendance);
		}
		
		
		
		return tasks;
	}
	
	public void save(Attendance attendance) {
		
		attendanceRepo.save(attendance);
	}
	
	
	
	public void delete(Attendance attendance) {
		
		attendanceRepo.delete(attendance);
	}

	public void delete(int taskId) {
		
		attendanceRepo.delete(taskId);
	}
}
