package blockchain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class KeyFetcher {
    
    public String  getKey()
    {


            String key="";
        try
        {
            Statement st=new DBConnection().getDBConnection();


            String query="Select * from blockchaininfo";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                
               key=rs.getString(3);
            
            }
          
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at KeyFetcher Class in : "+e);
            
        }
       
      return key;
    }
 


}
