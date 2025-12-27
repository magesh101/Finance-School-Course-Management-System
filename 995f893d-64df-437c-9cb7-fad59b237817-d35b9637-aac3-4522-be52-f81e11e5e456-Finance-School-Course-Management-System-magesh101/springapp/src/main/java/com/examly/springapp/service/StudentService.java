package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Student;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    Student getStudentByEmail(String email);
}
