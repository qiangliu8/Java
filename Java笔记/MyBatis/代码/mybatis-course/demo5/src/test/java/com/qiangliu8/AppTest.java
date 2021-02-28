package com.qiangliu8;

import static org.junit.Assert.assertTrue;

import com.qiangliu8.dao.StudentDao;
import com.qiangliu8.domain.Student;
import com.qiangliu8.utils.MyBatisUtils;
import com.qiangliu8.vo.QueryParam;
import com.qiangliu8.vo.ViewStudent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public  void TestIntCount(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println(studentDao.countStudent());
    }

    @Test
    public  void TestSelectStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectStudent();
        System.out.println(studentList);
    }

    @Test
    public  void TestSelectViewStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = studentDao.selectViewStudent(1001);
        System.out.println(student);
    }
    @Test
    public  void TestSelectMapById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Map<Object,Object> student = studentDao.selectMapById(1001);
        System.out.println(student);
    }

    @Test
    public  void TestSelectStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectStudents();
        System.out.println(studentList);
    }

    @Test
    public  void TestSelectStudents1(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectStudents1();
        System.out.println(studentList);
    }
    @Test
    public  void TestSelectStudents2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectStudents1();
        System.out.println(studentList);
    }

    @Test
    public  void TestSelectStudentsLike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        String name = "%强%";
        List<Student> studentList = studentDao.selectStudentsLike(name);
        System.out.println(studentList);
    }


    @Test
    public  void TestSelectStudentsLike2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        String name = "强";
        List<Student> studentList = studentDao.selectStudentsLike2(name);
        System.out.println(studentList);
    }
}
