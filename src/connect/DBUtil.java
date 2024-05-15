package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static Connection con;
    
    private DBUtil()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order_management", "root","KJkj@2603");    
		    System.out.println("Connected to the database");
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static Connection getConnect()
    {
        if (con == null) {
            new DBUtil();
        }
        return con;
    }
    
}

