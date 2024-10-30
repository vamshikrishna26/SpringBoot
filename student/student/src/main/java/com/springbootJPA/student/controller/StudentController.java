package com.springbootJPA.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootJPA.student.entity.StudentEntity;
import com.springbootJPA.student.repo.StudentRepo;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/createStudent")
	public StudentEntity createStudent(@RequestBody StudentEntity studentEntity) {
		return studentRepo.save(studentEntity);
		
	}
	
	@GetMapping("/getStudents")
	public List<StudentEntity>getStudent(){
		return studentRepo.findAll();
		
	}
	
	@GetMapping("/getStudents/{studentId}")
	public Optional<StudentEntity> getStudent(@PathVariable("studentId") int studentId) {
		return studentRepo.findById(studentId);
	}
	
	
	@PutMapping("/getStudents/updateStudent/{studentId}")
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable("studentId") int studentId, @RequestBody StudentEntity Student1){
		Optional<StudentEntity> checkStudent=studentRepo.findById(studentId);
		if(checkStudent.isPresent()) {
			checkStudent.get().setStudentId(Student1.getStudentId());
			checkStudent.get().setStudentFname(Student1.getStudentFname());
			checkStudent.get().setStudentLname(Student1.getStudentLname());
			checkStudent.get().setPhoneNumber(Student1.getPhoneNumber());
			checkStudent.get().setAddress(Student1.getAddress());
			return new ResponseEntity<>(studentRepo.save(checkStudent.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/getStudents/deleteStudent/{studentId}")
	public ResponseEntity<Void>  deleteStudent(@PathVariable("studentId") int studentId){
		studentRepo.deleteById(studentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
