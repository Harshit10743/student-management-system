package com.example.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.lms.Exception.StudentNotFoundException;
import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.model.Student;
import com.example.lms.repository.StudentRepository;
@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StudentRepository repos;

    public String getStudentInfo() {
        return "Student Service is working!";
    }
    
    public String getStudentCount() {

    String sql = "SELECT COUNT(*) FROM students";

    return jdbcTemplate.queryForObject(sql, Integer.class).toString();
}

public List<Student> getAllStudents() {
    return repos.findAll();
}
public Student getStudentById(Long id) {
    return repos.findById(id)
        .orElseThrow(() ->
            new StudentNotFoundException("Student not found with id: " + id)
        );
}
public Student addStudent(StudentRequestDTO dto) {

    Student student = new Student();
    
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

    return repos.save(student);
}

}
