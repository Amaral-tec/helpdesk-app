package com.amaral.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaral.helpdesk.model.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

}
