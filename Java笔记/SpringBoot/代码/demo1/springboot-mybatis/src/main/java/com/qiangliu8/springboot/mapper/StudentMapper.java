package com.qiangliu8.springboot.mapper;

import com.qiangliu8.springboot.model.Student;
import org.apache.ibatis.annotations.Mapper;


public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}