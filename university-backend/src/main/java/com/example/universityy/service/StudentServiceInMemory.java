package com.example.universityy.service;

import org.springframework.stereotype.Service;

import com.example.universityy.model.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentServiceInMemory implements StudentService {
	private final Map<Long, Student> students = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public Student create(Student student) {
        long id = idCounter.getAndIncrement();
        student.setId(id);
        students.put(id, student);
        return student;
    }

    @Override
    public Optional<Student> update(Long id, Student student) {
        Student existing = students.get(id);
        if (existing == null) return Optional.empty();
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setMajor(student.getMajor());
        students.put(id, existing);
        return Optional.of(existing);
    }

    @Override
    public boolean delete(Long id) {
        return students.remove(id) != null;
    }
}
