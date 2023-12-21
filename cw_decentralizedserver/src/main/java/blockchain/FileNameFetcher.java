package blockchain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class FileNameFetcher {
    
    public ArrayList getFileDetails()
    {
   
        ArrayList data= new ArrayList();
        try
        {
            
            Statement st=new DBConnection().getDBConnection();

            String query="Select * from taskinfo";
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {

                ArrayList nm=new ArrayList();
            nm.add(rs.getString(1));
            nm.add(rs.getString(4));
           
            data.add(nm);
            }
            
      
        }
         
            
        catch(Exception e)
        {
            System.out.println("Exception at FileNameFetcher "+e);
            
        }
       
      return data;
    }
 


}
