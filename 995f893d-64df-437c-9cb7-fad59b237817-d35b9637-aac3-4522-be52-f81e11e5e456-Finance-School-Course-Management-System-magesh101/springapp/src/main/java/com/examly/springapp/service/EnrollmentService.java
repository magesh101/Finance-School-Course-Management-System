package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Enrollment;

public interface EnrollmentService {
    Enrollment saveEnrollment(Enrollment enrollment);
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(Long id);
}
