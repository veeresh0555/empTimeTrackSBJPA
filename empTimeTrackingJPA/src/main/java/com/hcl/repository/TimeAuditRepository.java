package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.LoginTimeAudit;

public interface TimeAuditRepository extends JpaRepository<LoginTimeAudit,Long> {

}
