package com.hand;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 单例
 * 建立与数据库的连接
 */

public class ConnectionFactory {
    private static String dburl;
    private static String user;
    private static String password;

    private static ConnectionFactory factory = new ConnectionFactory();

    private Connection conn;

    static{
        // 保存属性文件中的键值对
        Properties properties = new Properties();
        try{
            // 首先获取当前类的类加载器，调用getResourceAsStream方法读取内容
            InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            // 从输入流中读取值
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        dburl = properties.getProperty("dburl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

    }

    private ConnectionFactory(){

    }

    protected static ConnectionFactory getInstance(){
        return factory;
    }

    public Connection makeConnection(){
        try{
            conn = DriverManager.getConnection(dburl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}

