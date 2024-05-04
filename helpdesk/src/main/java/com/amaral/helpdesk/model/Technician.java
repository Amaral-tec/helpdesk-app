package com.amaral.helpdesk.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.amaral.helpdesk.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "technicians")
@PrimaryKeyJoinColumn(name = "id")
public class Technician extends User {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "technician")
	private List<Ticket> tickets = new ArrayList<>();

	public Technician() {
		super();
		addProfile(Profile.TECHNICIAN);
	}

	public Technician(Long id, String name, String email, String phone, String cpf, String password) {
		super(id, name, email, phone, cpf, password);
		addProfile(Profile.TECHNICIAN);
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
