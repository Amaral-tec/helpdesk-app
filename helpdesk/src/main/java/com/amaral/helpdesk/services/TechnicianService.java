package com.amaral.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaral.helpdesk.exceptions.ObjectNotFoundException;
import com.amaral.helpdesk.model.Technician;
import com.amaral.helpdesk.model.dto.TechnicianDTO;
import com.amaral.helpdesk.repositories.ITechnicianRepository;

@Service
public class TechnicianService {

	@Autowired
	private ITechnicianRepository technicianRepository;
	
	public Technician update(Long id, @Valid TechnicianDTO objDTO) {

		objDTO.setId(id);
		Technician oldObj = findById(id);
		oldObj = new Technician(objDTO);
		return technicianRepository.save(oldObj);
	}
	
	public Technician findById(Long id) {
		Optional<Technician> obj = technicianRepository.findById(id.intValue());
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}


	public List<Technician> findAll() {
		
		return technicianRepository.findAll();
	}


	public Technician create(TechnicianDTO objDTO) {
		
		objDTO.setId(null);
		Technician newObj = new Technician(objDTO);
		return technicianRepository.save(newObj);
	}

}
