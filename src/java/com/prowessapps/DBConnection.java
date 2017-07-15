package com.prowessapps;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection con;
    public static Connection getDbConnection()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stp17july","root","password");
        }
        catch(Exception e)
        {
            System.out.println("Error in Connection"+e);
        }
        return con;
    }
}
