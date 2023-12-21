package blockchain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class WorkerNumFetcher {
    
    public String getDetails(String workername)
    {
        System.out.println("workername "+workername);

        String num="";
        
        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBConnection().getDBConnection();

            String query="Select * from workerinfo where username='"+workername+"'";
            ResultSet rs=st.executeQuery(query);
       
            if(rs.next())
            {
               
                num=rs.getString(2);
        
            }
            
            System.out.println("ar is  "+ar);
    
        }
          
            
        catch(Exception e)
        {
            System.out.println("Exception at WorkerNumFetcher Class in "+e);
            
        }
       
      return num;
    }
 


}
