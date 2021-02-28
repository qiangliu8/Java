package com.qiangliu8;

import com.qiangliu8.dao.StudentDao;
import com.qiangliu8.domain.Student;
import com.qiangliu8.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents(){
        //使用mybatis动态代理机制，使用SqlSession.getmapper(接口)
        //getMapper能获取dao接口对于的实现类对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        List<Student> studentList = studentDao.selectStudents();
        System.out.println(studentList);
    }
    @Test
    public void testInseretStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student1 = new Student(100861,"范马勇次郎","shs.c2m",35);
        System.out.println(studentDao.insertStudents(student1));
        sqlSession.commit();
        sqlSession.close();
    }
}
