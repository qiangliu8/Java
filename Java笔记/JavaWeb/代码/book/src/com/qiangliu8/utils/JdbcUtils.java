package com.qiangliu8.utils;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static{
           try {
               Properties properties = new Properties();
               //读取jdbc.properties属性配置文件
               InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
               //从流中读取加载数据
               properties.load(inputStream);
               //创建 数据库连接池
               dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//   获取数据库池中的连接
    public static Connection getConnection(){
        Connection connection = conns.get();
        if (connection==null){
            try {
                connection = dataSource.getConnection();//从数据连接池中获取链接
                conns.set(connection);// 保存到ThreadLocal对象中，供后面的jdbc操作使用
                connection.setAutoCommit(false); //设置手动管理
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
    //提交事务并关闭链接
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection!=null){
            //如果不等于null相当于连接过数据库
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//释放链接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        //一定要执行remove操作，否则会出错。因为Tomcat底层使用了线程池技术
        conns.remove();
    }
    //回滚事务并关闭链接
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection!=null){
            try {
                connection.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        conns.remove();
    }
//    //关闭连接
//    public static void close(Connection connection){
//        if (connection!=null){
//            try{
//                connection.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//        }
//    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
