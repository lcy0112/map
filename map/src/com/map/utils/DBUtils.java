package com.map.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    private static String driverClass;
    private static String url;
    private static String name;
    private static String password;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        name = rb.getString("name");
        password = rb.getString("password");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }

    public static void clossAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if(conn != null){
            conn.close();
        }

        if(stmt != null){
            stmt.close();
        }

        if(rs != null){
            rs.close();
        }
    }

}
