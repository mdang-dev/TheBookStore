/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtentionLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class XJdbc {
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dburl = "jdbc:sqlserver://localhost:1433; databaseName=TheBookStore;encrypt =false;trustServerCertificate=false";
    public static String user = "sa";
    public static String pass = "123456";
      
    static 
    {
        try 
        {
            Class.forName(driver);
        } 
        catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public static PreparedStatement getStatement (String sql, Object... args) throws SQLException
    {
        Connection connect = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement statement;
        if (sql.trim().startsWith("{"))
        {
            statement = connect.prepareCall(sql);
        }
        else 
        {
            statement = connect.prepareStatement(sql);
        }
        
        for (int i = 0, n = args.length; i < n; i++)
        {
            statement.setObject(i + 1, args[i]);
        }
        
        return statement;
    }
    
    public static ResultSet query(String sql, Object... args) throws SQLException
    {
        PreparedStatement statement = XJdbc.getStatement(sql, args);
        return statement.executeQuery();
    }
    
    public static Object value(String sql, Object... args) throws SQLException
    {
        ResultSet rs = XJdbc.query(sql, args);
        if (rs.next())
        {
            return rs.getObject(1);
        }
        rs.getStatement().getConnection().close();
        return null;
    }
    
     public static int update(String sql, Object...args) {
        try {
            PreparedStatement stmt = XJdbc.getStatement(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
  

