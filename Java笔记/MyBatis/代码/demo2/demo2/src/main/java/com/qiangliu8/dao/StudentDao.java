package com.qiangliu8.dao;

import com.qiangliu8.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudent();
    int insertStudents(Student student);
}
