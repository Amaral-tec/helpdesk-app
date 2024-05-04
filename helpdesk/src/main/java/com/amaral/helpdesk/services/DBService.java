package com.amaral.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amaral.helpdesk.enums.Priority;
import com.amaral.helpdesk.enums.Status;
import com.amaral.helpdesk.model.Client;
import com.amaral.helpdesk.model.Technician;
import com.amaral.helpdesk.model.Ticket;
import com.amaral.helpdesk.repositories.IClientRepository;
import com.amaral.helpdesk.repositories.ITechnicianRepository;
import com.amaral.helpdesk.repositories.ITicketRepository;

@Service
public class DBService {
	
	@Autowired
	private ITechnicianRepository technicianRepository;
	
	@Autowired
	private IClientRepository clientRepository;
	
	@Autowired
	private ITicketRepository ticketRepository;

	public void databaseInstance() {
		
		Technician tec1 = new Technician(null, "Leandro Amaral", "amaral_adm@hotmail.com", "5584996321321", "26446756003", "yu589eRt");
		technicianRepository.saveAll(Arrays.asList(tec1));
		
		Client cli1 = new Client(null, "Joarlla Medeiros", "client@email.com", "5584999999000", "69164541053", "78erTg89");
		clientRepository.saveAll(Arrays.asList(cli1));
		
		Ticket tic1 = new Ticket(null, "Ticket 1", "Test Description", Status.OPEN, Priority.LOW, cli1, tec1);
		ticketRepository.saveAll(Arrays.asList(tic1));
	}
}
