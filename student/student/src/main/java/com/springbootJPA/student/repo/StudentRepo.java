package com.springbootJPA.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootJPA.student.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

}
