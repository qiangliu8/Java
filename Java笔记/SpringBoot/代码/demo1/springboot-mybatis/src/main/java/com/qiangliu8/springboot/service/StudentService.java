package com.qiangliu8.springboot.service;

import com.qiangliu8.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

public interface StudentService {
    public Student selectStu(Integer id);
    public int updateStudent(Student student);
}
