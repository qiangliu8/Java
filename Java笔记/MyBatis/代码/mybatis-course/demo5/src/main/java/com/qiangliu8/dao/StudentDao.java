package com.qiangliu8.dao;

import com.qiangliu8.domain.Student;
import com.qiangliu8.vo.QueryParam;
import com.qiangliu8.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    int countStudent();
    List<Student> selectStudent();
    ViewStudent selectViewStudent(@Param("id") Integer id);

    Map<Object,Object> selectMapById(Integer id);

    //使用resultMap定义映射关系
    List<Student> selectStudents();
    List<Student> selectStudents1();
    List<Student> selectStudents2();


    List<Student> selectStudentsLike(String name);

    List<Student> selectStudentsLike2(String name);
}
