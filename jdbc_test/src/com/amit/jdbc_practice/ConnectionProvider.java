package com.amit.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static String userName = "root";
    private static String password = "system123";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static Connection conn;
    //getConnection method, return an object/instance of Connection.
    public static Connection getConnection(){
        try {
            if (conn==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url,userName,password);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
