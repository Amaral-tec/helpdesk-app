package com.amaral.helpdesk.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.amaral.helpdesk.enums.Profile;
import com.amaral.helpdesk.model.Technician;

public class TechnicianDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    protected Long id;
	
    @NotBlank
    protected String name;
	
    @Email
    protected String email;
	
    @NotBlank
    protected String phone;
	
    @CPF
    @NotBlank
    protected String cpf;
	
    @NotBlank
    protected String password;
    
    protected Set<Integer> profiles = new HashSet<>();
    
    protected LocalDate createdAt;
    
    protected Boolean isDeleted;

	public TechnicianDTO() {
		super();
		addProfile(Profile.TECHNICIAN);
	}

	public TechnicianDTO(Technician obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.cpf = obj.getCpf();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.createdAt = obj.getCreatedAt();
		this.isDeleted = obj.getIsDeleted();
		addProfile(Profile.TECHNICIAN);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
 
}
