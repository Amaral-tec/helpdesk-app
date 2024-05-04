package com.amaral.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaral.helpdesk.model.Client;

public interface IClientRepository extends JpaRepository<Client, Integer> {

}
