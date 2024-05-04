package com.amaral.helpdesk.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.amaral.helpdesk.enums.Profile;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", initialValue = 1, allocationSize = 1)
public abstract class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    protected Long id;
	
	@NotBlank
	@Column(nullable = false)
    protected String name;
	
	@Email
	@Column(unique = true, nullable = false)
    protected String email;
	
	@NotBlank
	@Column(nullable = false)
	protected String phone;
	
	@CPF
	@Column(unique = true, nullable = false)
	protected String cpf;
	
	@NotBlank
	@Column(nullable = false)
    protected String password;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles")
    protected Set<Integer> profiles = new HashSet<>();
    
	@Column(name = "created_at")
    protected LocalDate createdAt = LocalDate.now();
    
    @Column(name = "is_deleted")
    protected Boolean isDeleted = Boolean.FALSE;

	public User() {
		super();
		addProfile(Profile.USER);
	}

	public User(Long id, String name, String email, String phone, String cpf, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.password = password;
		addProfile(Profile.USER);
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
    
}
