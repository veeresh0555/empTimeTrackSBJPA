package com.hcl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.exception.RecordsNotFound;
import com.hcl.model.Employe;
import com.hcl.model.LoginTimeAudit;
import com.hcl.repository.EmployeeRepository;
import com.hcl.repository.TimeAuditRepository;

@Service
@Transactional
public class EmployeServiceImp implements EmployeService {

	@Autowired
	EmployeeRepository emprepository;
	
	@Autowired
	TimeAuditRepository trepostory;
	
	@Override
	public Employe empsave(Employe emp) {
		Optional<Employe> employee = emprepository.findById(emp.getEid());
		if (employee.isPresent()) {
			Employe empupdateentity = employee.get();
			empupdateentity.setEname(emp.getEname());
			empupdateentity.setDesignation(emp.getDesignation());
			empupdateentity.setLocation(emp.getLocation());
			empupdateentity = emprepository.save(empupdateentity);
            return empupdateentity;
        } else {
        	emp = emprepository.save(emp);
            return emp;
        
		}
	}
	
	@Autowired
	public List<Employe> getAllEmployees() throws RecordsNotFound {
        List<Employe> employeeList = emprepository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
           throw new RecordsNotFound();
        }
    }

	@Override
	public LoginTimeAudit auditsave(LoginTimeAudit audit) throws RecordsNotFound {
		Optional<Employe> emp=emprepository.findById(audit.getId());
		
		try {
		if(emp.isPresent()) {
			Employe empentity = emp.get();
			LoginTimeAudit audit1=new LoginTimeAudit();
			audit1.setFlag(audit.getFlag());
			empentity.setEid(emp.get().getEid());
			audit1.setEmp(empentity);
			audit=trepostory.save(audit1);
			
		}else {
			System.out.println("No records found....");
			 throw new RecordsNotFound();
		}
		} catch (Exception e) {
			throw new InternalError();
		}
		return audit;
	}

	@Override
	public List<LoginTimeAudit> getAllEmpSwipeReport() throws RecordsNotFound {
		 List<LoginTimeAudit> swipereport=new ArrayList<LoginTimeAudit>(); 
		 try {
			 swipereport= trepostory.findAll();
			 if(swipereport.size() > 0) {
				return swipereport;
		        } else {
		        	System.out.println("*****No records found....");
		        	throw new RecordsNotFound();
		        }
		} catch (Exception e) {
			throw new InternalError(""+e.getMessage());
		}
		 
		    
	}
	
	
	
	
	
	
	
	
	
	
}
