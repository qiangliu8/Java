package com.qiangliu8.dao;

import com.qiangliu8.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentwhere(Student student);

    List<Student> selectStuForeachOne(List<Integer> idList);

    List<Student> selectStuForeach2(List<Student> studentList);

    List<Student> selectAll();
}
