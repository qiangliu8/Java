package com.qiangliu8;

import static org.junit.Assert.assertTrue;

import com.qiangliu8.dao.StudentDao;
import com.qiangliu8.domain.Student;
import com.qiangliu8.utils.MyBatisUtils;
import com.qiangliu8.vo.QueryParam;
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
    public void testInsert() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.getStudentById(10086);
        sqlSession.close();
        System.out.println(student);
    }

    @Test
    public void testSelectMulitParam() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectMulitParam("刘强",24);
        sqlSession.close();
        System.out.println(studentList);
    }

    @Test
    public void testSelectMultiObject() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam("刘强",18);
        List<Student> studentList = studentDao.selectMultiObject(queryParam);
        System.out.println(studentList);
        sqlSession.close();
    }

    @Test
    public void testSelectIndex() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectIndex("刘强",18);
        System.out.println(studentList);
        sqlSession.close();
    }

    @Test
    public void testSelectMap() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Map<String,Object> map = new HashMap<>();
        map.put("mapName","刘强");
        map.put("mapAge",18);
        List<Student> studentList = studentDao.selectMap(map);
        System.out.println(studentList);
        sqlSession.close();
    }


    @Test
    public void testSelectUserOrder$() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.selectUserOrder$("name");
        System.out.println(studentList);
        sqlSession.close();
    }
}
