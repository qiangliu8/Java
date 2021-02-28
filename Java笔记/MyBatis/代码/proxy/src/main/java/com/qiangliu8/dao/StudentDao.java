package com.qiangliu8.dao;

import com.qiangliu8.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudents(Student student);
}
