package com.qiangliu8.dao;

import com.mysql.cj.Session;
import com.qiangliu8.domain.Student;
import com.qiangliu8.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    @Override
    public List<Student> selectStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.qiangliu8.dao.StudentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudents(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.qiangliu8.dao.StudentDao.insertStudents";
        int count = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
