package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.exception.RecordsNotFound;
import com.hcl.model.Employe;
import com.hcl.model.LoginTimeAudit;
import com.hcl.service.EmployeService;

@RestController
public class TestController {

	
	@Autowired
	EmployeService empservice;
	
	
	@PostMapping("/empsave")
	public ResponseEntity<Employe> saveemployee(Employe emp){//@RequestBody 
		Employe updateemp=empservice.empsave(emp);
		return new ResponseEntity<Employe>(updateemp, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employe>> getAllEmployees() throws RecordsNotFound {
        List<Employe> list = empservice.getAllEmployees();
        return new ResponseEntity<List<Employe>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	
	@PostMapping("/timesave")
	public ResponseEntity<?> timesave(LoginTimeAudit audit) throws RecordsNotFound{//@RequestBody 
		LoginTimeAudit updateaudit=null;
		try {
			updateaudit=empservice.auditsave(audit);	
		}catch (RuntimeException ex) {
			throw new RuntimeErrorException(null, ex.getMessage());
		} 
		catch (Exception e) {
			throw new RecordsNotFound("Records Not Found-("+e.getMessage()+")");
			// TODO: handle exception
		}
		return new ResponseEntity<LoginTimeAudit>(updateaudit, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getswipeReport")
    public ResponseEntity<List<LoginTimeAudit>> getSwipeReports() throws RecordsNotFound {
		List<LoginTimeAudit> list = empservice.getAllEmpSwipeReport();
        return new ResponseEntity<List<LoginTimeAudit>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	
	
	
	
	
}
