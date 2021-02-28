package com.qiangliu8.dao;

import com.qiangliu8.domain.Student;
import com.qiangliu8.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student getStudentById(Integer id);
    //多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")
    public List<Student> selectMulitParam(@Param("myName") String name, @Param("myAge") Integer age);
    //多个参数：使用Java对象作为接口中方法的参数
    List<Student> selectMultiObject(QueryParam param);
    List<Student> selectIndex(String name,Integer age);
    List<Student> selectMap(Map<String,Object> map);

    List<Student> selectUserOrder$(@Param("colName") String colName);
}
