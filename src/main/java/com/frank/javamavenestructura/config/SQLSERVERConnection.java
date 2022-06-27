package com.frank.javamavenestructura.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLSERVERConnection {
    private static Connection conn;
    private final static String url = "jdbc:sqlserver://DESKTOP-85NKVO2\\SQLEXPRESS;databaseName=master;integratedSecurity=true";
    private final static String dbName = "testdb";
    private final static String user = "sa";
    private final static String ip="localhost";
    private final static String password = "h@acker644";
    private final static String port="1434";
            
    public static Connection getConnection(){
        String temUrl = "jdbc:sqlserver://"+ip+":"+port+"/"+dbName;
        String cadena = "jdbc:sqlserver://DESKTOP-85NKVO2\\SQLEXPRESS:"+port+";"+"databaseName="+dbName+";integratedSecurity=false;encrypt=false;trustServerCertificate=false";
        //Conexion
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(cadena,user,password);
            return conn;
        }catch(Exception ex){
            System.out.println("Error.Connection.SQLSERVER: "+ex);
            return null;
        }
    }
}
