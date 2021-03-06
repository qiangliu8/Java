package com.qiangliu8.service.impl;

import com.qiangliu8.dao.StudentDao;
import com.qiangliu8.domain.Student;
import com.qiangliu8.service.StudentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //引用类型自动注入@Autowired, @Resource
    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.selectStudents();
    }
}
