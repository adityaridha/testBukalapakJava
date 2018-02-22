package com.bukalapak;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection(){
        Connection connection = null;

        String DBDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bukalapak";
        String username = "aditya";
        String password = "aditya";

        try{
            Class.forName(DBDriver);
            connection = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
