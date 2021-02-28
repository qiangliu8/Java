package com.qiangliu8;

import static org.junit.Assert.assertTrue;

import com.github.pagehelper.PageHelper;
import com.qiangliu8.dao.StudentDao;
import com.qiangliu8.domain.Student;
import com.qiangliu8.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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
    public  void TestSelectStudentIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1001,"刘强","1102644615@sqq.com",null);
        List<Student> studentList = studentDao.selectStudentIf(student);
        System.out.println(studentList);
    }
    @Test
    public  void TestSelectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1001,"刘强","1102644615@sqq.com",20);
        List<Student> studentList = studentDao.selectStudentwhere(student);
        System.out.println(studentList);
    }

    @Test
    public  void TestForeach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        String sql = "select * from student where id in ";
        StringBuilder builder = new StringBuilder("");
        int init = 0;
        int len = list.size();
        builder.append("(");
        for (Integer i:list) {
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        System.out.println(sql+builder.toString());
    }

    @Test
    public  void TestForeach2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1001);
        integerList.add(1002);
        integerList.add(1003);
        List<Student> studentList = studentDao.selectStuForeachOne(integerList);
        System.out.println(studentList);
        sqlSession.close();
    }


    @Test
    public  void TestForeach3(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1001,null,null,null));
        studentList.add(new Student(1002,null,null,null));
        studentList.add(new Student(1003,null,null,null));
        List<Student> studentList2 = studentDao.selectStuForeach2(studentList);
        System.out.println(studentList2);
        sqlSession.close();
    }

    @Test
    public  void TestAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper方法，分页
        //pageNum：第几页，从1开始
        //pageSize:一夜中有多少行数据
        PageHelper.startPage(2,3);
        List<Student> studentList = studentDao.selectAll();
        System.out.println(studentList);
        sqlSession.close();
    }
}
