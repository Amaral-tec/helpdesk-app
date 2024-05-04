package com.amaral.helpdesk.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.amaral.helpdesk.enums.Priority;
import com.amaral.helpdesk.enums.Status;

@Entity
@Table(name = "tickets")
@SequenceGenerator(name = "seq_ticket", sequenceName = "seq_ticket", initialValue = 1, allocationSize = 1)
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ticket")
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String title;
	
	@NotBlank
	@Column(nullable = false)
	private String description;
	
	@Column(name = "scheduled_date")
	private LocalDate scheduledDate = LocalDate.now();
	
	@Column(name = "completion_date")
	private LocalDate completionDate;
	
	private Status status;
	
	@Column(nullable = false)
	private Priority priority;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "technician_id")
	private Technician technician;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted = Boolean.FALSE;

	public Ticket() {
		super();
	}

	public Ticket(Long id, String title, String description, Status status, Priority priority, Client client,
			Technician technician) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.client = client;
		this.technician = technician;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
	
}
