package com.qiangliu8;


import com.qiangliu8.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

public class MyApp {
    public static void main(String[] args) throws IOException {
//      访问mybatis读取student数据
//      1.定义mybatis著配置文件的名称，从类数据的根开始（target/classess）
        String config= "mybatis.xml";
//      2.读取这个config表示的文件
        InputStream inputStream = Resources.getResourceAsStream(config);
//      3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//      4.创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//      5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//      6.指定要执行的sql语句的表示。sql映射文件中的namespace+“。”+标签的id值
        String sqlId = "com.qiangliu8.dao.StudentDao.selectStudents";
//      7.执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
//      8.输出结果
        studentList.forEach(stu -> System.out.println(stu));
//      9.关闭sqlSession对象
        sqlSession.close();

    }
}
