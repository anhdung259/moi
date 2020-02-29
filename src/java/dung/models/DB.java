/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pham Anh Dung
 */
public class DB {
   public static Connection getConnection() throws Exception{
       Connection conn = null;
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String url ="jdbc:sqlserver://localhost:1433;databaseName=Homestay";
       conn=DriverManager.getConnection(url,"sa","12345");
       return conn;
   }
}
