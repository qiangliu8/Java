package com.qiangliu8.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qiangliu8.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    //javaBean和json的互转
    @Test
    public void test1(){
        Person person = new Person(1,"刘强");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以将java对象转换成json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        //toJson方法可以将json字符串转换成java对象
        Person person1 = gson.fromJson(personJsonString,Person.class);
        System.out.println(person1);
    }
    //Map和json的互转
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();

        personMap.put(1,new Person(1,"刘强"));
        personMap.put(2,new Person(2,"俞文竹"));
        Gson gson = new Gson();

        String personMapString = gson.toJson(personMap);
        System.out.println(personMapString);
        Map<Integer,Person> map = gson.fromJson(personMapString,new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(map);
        System.out.println(map.get(1));
     }
    //List和json的互转
    @Test
    public void test2(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"刘强"));
        list.add(new Person(2,"俞文竹"));
        Gson gson = new Gson();
        String personListString = gson.toJson(list);
        System.out.println(personListString);
        List list1 = gson.fromJson(personListString,new PersonListType().getType());
        Person person = (Person) list1.get(0);
        System.out.println(person);
    }
}
