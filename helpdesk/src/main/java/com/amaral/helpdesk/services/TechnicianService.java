package com.amaral.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaral.helpdesk.exceptions.ObjectNotFoundException;
import com.amaral.helpdesk.model.Technician;
import com.amaral.helpdesk.repositories.ITechnicianRepository;

@Service
public class TechnicianService {

	@Autowired
	private ITechnicianRepository technicianRepository;
	
	
	public Technician findById(Integer id) {
		Optional<Technician> obj = technicianRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}
}
