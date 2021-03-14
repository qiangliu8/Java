package com.qiangliu8.springboot.service;

import com.qiangliu8.springboot.mapper.StudentMapper;
import com.qiangliu8.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectStu(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateStudent(Student student) {
        int i = studentMapper.updateByPrimaryKey(student);
        int a = 10/0;
        return i;
    }
}
