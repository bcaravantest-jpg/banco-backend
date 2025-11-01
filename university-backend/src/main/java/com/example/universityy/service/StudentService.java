package com.example.universityy.service;

import java.util.List;
import java.util.Optional;

import com.example.universityy.model.Student;

public interface StudentService {
	List<Student> findAll();
    Optional<Student> findById(Long id);
    Student create(Student student);
    Optional<Student> update(Long id, Student student);
    boolean delete(Long id);
}
