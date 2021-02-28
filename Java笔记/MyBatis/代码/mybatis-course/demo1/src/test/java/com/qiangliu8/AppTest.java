package com.qiangliu8;

import static org.junit.Assert.assertTrue;

import com.qiangliu8.domain.Student;
import com.qiangliu8.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
        //      6.指定要执行的sql语句的表示。sql映射文件中的namespace+“。”+标签的id值
        String sqlId = "com.qiangliu8.dao.StudentDao.insertStudents";
        Student student = new Student(10022,"吴云1","1102644615@qq.com",24);
        //      7.执行sql语句，通过sqlId找到语句
        int i = sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务的，所以在insert , update , delete后要手工提交事务
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }
}
