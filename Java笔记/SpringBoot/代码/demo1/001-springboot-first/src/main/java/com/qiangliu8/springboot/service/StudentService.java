package com.qiangliu8.springboot.service;

import com.qiangliu8.springboot.model.Student;
import org.springframework.stereotype.Service;

public interface StudentService {

    /*根据学生id查询详情*/
    Student queryStudentById(Integer id);
}
