package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

    public Connection createConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost:3306/"+Credentials.DATABASE+"?characterEncoding=utf8&useUnicode=true&userJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            connection= DriverManager.getConnection(dbURL,Credentials.USERNAME,Credentials.PASSWORD);
            System.out.println("Connection to the db was successful.");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}