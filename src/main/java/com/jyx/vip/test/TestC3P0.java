package com.jyx.vip.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestC3P0 {
//    private static ComboPooledDataSource dataSource1 = new ComboPooledDataSource("test");
    private static ComboPooledDataSource dataSource2 = new ComboPooledDataSource();
    private static void getConnection(){
//        try{
//            Connection connection = dataSource1.getConnection();
//            System.out.println("连接数据库 product 成功！");
//            connection.close();
//            System.out.println("数据库连接已关闭！");
//        }catch(Exception e){
//            System.out.println("连接数据库失败！");
//        }
        try{
            Connection connection = dataSource2.getConnection();
            System.out.println("连接数据库 customer 成功！");
            connection.close();
            System.out.println("数据库连接已关闭！");
        }catch(Exception e){
            System.out.println("连接数据库失败！");
        }
    }
    public static void main(String[] args){
        getConnection();
    }
}
