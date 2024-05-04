package com.amaral.helpdesk.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amaral.helpdesk.model.Technician;
import com.amaral.helpdesk.model.dto.TechnicianDTO;
import com.amaral.helpdesk.services.TechnicianService;

@RestController
public class TechnicianController {

	@Autowired
	private TechnicianService technicianService;
	
	@Autowired
	private LogController<Technician> logController;
	
	@GetMapping(value = "**/get-technician/{id}")
	public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
		
		Technician obj = technicianService.findById(id);
		logController.logEntity(obj);
		
		return new ResponseEntity<>(new TechnicianDTO(obj), HttpStatus.OK);
	}
	
	@GetMapping(value = "**/find-all-technician")
	public ResponseEntity<List<TechnicianDTO>> findAll() {
		
		List<Technician> list = technicianService.findAll();
		List<TechnicianDTO> listDTO = list.stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
		logController.logEntityList(list);
		
		return new ResponseEntity<>(listDTO, HttpStatus.OK);
	}
}
