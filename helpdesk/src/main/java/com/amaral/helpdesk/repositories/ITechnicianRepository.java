package com.amaral.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaral.helpdesk.model.Technician;

public interface ITechnicianRepository extends JpaRepository<Technician, Integer> {

}
