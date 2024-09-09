package com.vamshe.EmployeePortal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vamshe.EmployeePortal.Model.Employee;
import com.vamshe.EmployeePortal.Repo.EmployeeRepo;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping("/api/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(employeeRepo.save(employee),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/api/employee")
	public ResponseEntity<List<Employee>> getEmployees(){
		return new ResponseEntity<>(employeeRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/api/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id){
		Optional<Employee> employee=employeeRepo.findById(id);
		if(employee.isPresent()) {
			return new ResponseEntity<>(employee.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/api/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id,@RequestBody Employee emp){
		Optional<Employee> employee=employeeRepo.findById(id);
		if(employee.isPresent()) {
			employee.get().setEmployeeAddress(emp.getEmployeeAddress());
			employee.get().setEmployeeEmail(emp.getEmployeeEmail());
			employee.get().setEmployeeFirstName(emp.getEmployeeFirstName());
			employee.get().setEmployeeLastName(emp.getEmployeeLastName());
			employee.get().setEmployeeId(emp.getEmployeeId());
			return new ResponseEntity<>(employeeRepo.save(employee.get()),HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
		Optional<Employee> employee=employeeRepo.findById(id);
		if(employee.isPresent()) {
			employeeRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
