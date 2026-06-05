package com.example.lms.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.model.Student;
@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

  @GetMapping
  public ArrayList<Student> getStudent() {
    ArrayList<Student> students = new ArrayList<>();
    students.add(new Student(10743L, "Harshit", "Computer Science"));
    students.add(new Student(10809L, "Vansh Gupta", "Computer Science"));
    return students;
  }  
}