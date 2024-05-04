package com.amaral.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amaral.helpdesk.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
