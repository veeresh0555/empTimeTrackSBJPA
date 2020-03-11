package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Employe;

public interface EmployeeRepository extends JpaRepository<Employe, Long> {

}
