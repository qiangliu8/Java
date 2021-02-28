package com.qiangliu8;

import com.qiangliu8.dao.StudentDao;
import com.qiangliu8.dao.StudentDaoImpl;
import com.qiangliu8.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudents(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.selectStudent();
        System.out.println(list);
    }
    @Test
    public void testInseretStudents(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student1 = new Student(10086,"刃牙","shs.cm",18);
        int count = studentDao.insertStudents(student1);
        System.out.println(count);
    }
}
