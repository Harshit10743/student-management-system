package com.example.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.dto.StudentResponceDTO;
import com.example.lms.model.Student;
import com.example.lms.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // @GetMapping
    // public ArrayList<Student> getStudents() {
    //
    //     ArrayList<Student> students = new ArrayList<>();
    //
    //     students.add(
    //         new Student(10743L, "Harshit", "CSE")
    //     );
    //
    //     students.add(
    //         new Student(1080L, "Vansh Gupta", "CSE")
    //     );
    //
    //     return students;
    // }

    @GetMapping("/count")
    public String countStudents() {
        return studentService.getStudentCount();
    }

    @GetMapping("/message")
    public String getMessage() {
        return studentService.getStudentInfo();
    }

    @GetMapping
    public Object getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {

        Student student = studentService.getStudentById(id);

        StudentResponceDTO responseDTO = new StudentResponceDTO(
                student.getId(),
                student.getName(),
                student.getCourse()
        );

        return ResponseEntity.ok(responseDTO);
    }
    @PostMapping
public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto) {
    Student student = studentService.addStudent(dto);
    return ResponseEntity.ok(student);
}
}