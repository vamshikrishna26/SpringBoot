package com.springboot.RestAPIwJPA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.RestAPIwJPA.Model.StudentModel;

public interface StudentRepo extends JpaRepository<StudentModel, Long> {

}
