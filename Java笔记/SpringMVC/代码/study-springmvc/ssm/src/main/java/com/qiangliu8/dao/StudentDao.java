package com.qiangliu8.dao;

import com.qiangliu8.domain.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
