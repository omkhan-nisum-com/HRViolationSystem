package com.nisum.hr.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nisum.hr.dao.RolesRepository;

import com.nisum.hr.models.Roles;

@Service
@Transactional
public class RolesService {
	
	private RolesRepository rolesRepo;
	
	public RolesService(RolesRepository rolesRepo) {
		this.rolesRepo=rolesRepo;
	}
	
	
	public List<Roles> findAll(){
		
		List<Roles> rolesList =  new ArrayList<Roles>();
		for(Roles role : rolesRepo.findAll()) {
			
			rolesList.add(role);
		}
		
		
		
		return rolesList;
	}
	
	public Roles getRoleById(int id) {
		
		return rolesRepo.findOne(id);
	}

}
