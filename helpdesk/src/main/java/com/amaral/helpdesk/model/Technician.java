package com.amaral.helpdesk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "id")
public class Technician extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Ticket> tickets = new ArrayList<>();

	public Technician() {
		super();
	}

	public Technician(Long id, String name, String email, String phone, String cpf, Date dateBirth, String password) {
		super(id, name, email, phone, cpf, dateBirth, password);
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
