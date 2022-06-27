package com.frank.javamavenestructura.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ORACLEConnection {
    private final static String url = "jdbc:oracle:thin:@192.168.1.6:1521:orcl";
    private final static String user = "system";
    private final static String password = "h@acker644";
    private static Connection conn;
    
    public static Connection getConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        }catch(Exception ex){
            System.out.println("Error.Connection.Oracle: "+ex);
            return null;
        }
    }
}
