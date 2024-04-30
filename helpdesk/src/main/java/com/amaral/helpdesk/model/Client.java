package com.amaral.helpdesk.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User {

	private static final long serialVersionUID = 1L;
	

}
