package com.springboot.RestAPIwJPA.Controller;

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

import com.springboot.RestAPIwJPA.Model.StudentModel;
import com.springboot.RestAPIwJPA.Repo.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/api/students")
	public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel student) {
		return new ResponseEntity<>(studentRepo.save(student),HttpStatus.CREATED); //this return the same data
		
	}
	@GetMapping("/api/students")
	public ResponseEntity<List<StudentModel>> getStudents(){
		return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<StudentModel> getStudent(@PathVariable long id){
		Optional<StudentModel> student=studentRepo.findById(id);
		if(student.isPresent()) {
			return new ResponseEntity<>(student.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
	@PostMapping("/api/students/{id}")
	public ResponseEntity<StudentModel> updateStudent(@PathVariable long id,@RequestBody StudentModel Stud){
		Optional<StudentModel> student=studentRepo.findById(id);
		if(student.isPresent()) {
			student.get().setStudentAddress(Stud.getStudentAddress());
			student.get().setStudentEmail(Stud.getStudentEmail());
			student.get().setStudentName(Stud.getStudentName());
			return new ResponseEntity<>(studentRepo.save(student.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	@DeleteMapping("/api/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id){
		Optional<StudentModel> student=studentRepo.findById(id);
		if(student.isPresent()) {
			studentRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		}
		
	}
	
