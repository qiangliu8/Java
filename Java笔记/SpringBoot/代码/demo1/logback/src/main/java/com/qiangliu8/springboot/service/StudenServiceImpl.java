package com.qiangliu8.springboot.service;

import com.qiangliu8.springboot.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudenServiceImpl implements StudenService {
    @Autowired
    private StudentMapper studentMapper;

    public int studentCount(){
        log.trace("trace查询当前学生总人数：");
        log.debug("debug查询当前学生总人数：");
        log.info("info查询当前学生总人数：");
        log.warn("warn查询当前学生总人数：");
        log.error("error查询当前学生总人数：");
        return studentMapper.selectStudentCount();
    }

}
