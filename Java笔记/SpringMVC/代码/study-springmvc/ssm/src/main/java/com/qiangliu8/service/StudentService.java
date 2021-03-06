package com.qiangliu8.service;

import com.qiangliu8.domain.Student;
import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> findStudents();
}
