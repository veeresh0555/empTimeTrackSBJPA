package com.hcl.service;

import java.util.List;

import com.hcl.exception.RecordsNotFound;
import com.hcl.model.Employe;
import com.hcl.model.LoginTimeAudit;

public interface EmployeService {

	public Employe empsave(Employe emp);
	
	public List<Employe> getAllEmployees() throws RecordsNotFound;

	public LoginTimeAudit auditsave(LoginTimeAudit audit) throws RecordsNotFound;

	public List<LoginTimeAudit> getAllEmpSwipeReport() throws RecordsNotFound;

}
