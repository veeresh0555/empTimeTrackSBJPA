package com.hcl.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="loginaudit")
public class LoginTimeAudit {// implements Serializable

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	private Timestamp audittime;
	//private LocalDateTime audittime;
	private String flag;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
	@JsonIgnoreProperties
	private Employe emp;

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	public LoginTimeAudit() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAudittime() {
		return audittime;
	}

	public void setAudittime(Timestamp audittime) {
		this.audittime = audittime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public LoginTimeAudit(Long id, Timestamp audittime, String flag, Employe emp) {
		this.id = id;
		this.audittime = audittime;
		this.flag = flag;
		this.emp = emp;
	}

	
	
	
	
	
}
