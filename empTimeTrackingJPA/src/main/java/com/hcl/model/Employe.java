package com.hcl.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employe {// implements Serializable

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long eid;
   private String ename;
   private String designation;
   private String location;
	
   @OneToMany(mappedBy = "emp",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JsonManagedReference
   //@JsonBackReference
   private List<LoginTimeAudit> loginaudit;
	   
	public Long getEid() {
		return eid;
	}
		
	
	public void setEid(Long eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesignation() {
		return designation;
	}
	
	
	public List<LoginTimeAudit> getLoginaudit() {
		return loginaudit;
	}


	public void setLoginaudit(List<LoginTimeAudit> loginaudit) {
		this.loginaudit = loginaudit;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
