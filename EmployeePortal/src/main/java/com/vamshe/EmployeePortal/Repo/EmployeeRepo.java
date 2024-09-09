package com.vamshe.EmployeePortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vamshe.EmployeePortal.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
