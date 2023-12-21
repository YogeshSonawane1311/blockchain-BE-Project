/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;
import java.sql.*;
import java.util.ArrayList;

public class TableDataFetcher {
    
    public ArrayList getDetails()
    {
       
        ArrayList data= new ArrayList();
        try
        {
          
            Statement st=new DBDriver().getDriverStatement();
            String query="Select * from taskinfo";
            ResultSet rs=st.executeQuery(query);

           while(rs.next())
            {
               ArrayList ar=new ArrayList();
                
                String id=rs.getString(1);
                String proname=rs.getString(2);
                String tdes=rs.getString(5);
                String notask=rs.getString(6);
                String tdeadline=rs.getString(7);
                String tamt=rs.getString(8);
                String sdepo=rs.getString(9);
                
                
                
                      
                ar.add(id);
                ar.add(proname);
                ar.add(tdes);
                ar.add(notask);
                ar.add(tdeadline);
                ar.add(tamt);
                ar.add(sdepo);
                
                
                data.add(ar);
               
            }
            
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception in TableDataFetcher Class is: "+e);
            
        }
       
      return data;
    }
 


}
