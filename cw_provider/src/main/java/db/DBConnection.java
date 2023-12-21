
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
    
    public Statement getDBConnection() 
    {
        Statement st=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crowdsourcing?autoReconnect=true&useSSL=false","root","root");
            st=conn.createStatement();
           
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
        {
            System.out.println("Exception in DBConnection Class in getDBConnection() function is: "+e);
        }
        
        return st;
    }
    
}
