package db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.ArrayList;

public class WorkerKeyFetcher {
    
    public String  wgetDetails(String uname)
    {
     String key="";
        try
        {
            Statement st=new DBConnection().getDBConnection();
            String query="Select * from workerinfo where username='"+uname+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
             key=rs.getString(8);
            }
          
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return key;
    }
 


}
