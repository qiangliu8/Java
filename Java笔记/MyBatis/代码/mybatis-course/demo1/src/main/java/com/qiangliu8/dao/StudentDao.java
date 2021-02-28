package com.qiangliu8.dao;

import com.qiangliu8.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询所有student表的所有数据
    public List<Student> selectStudents();
    //插入方法
    //返回值 int 表示执行insert操作后的影响数据库的行数
    public int insertStudent(Student student);
}
