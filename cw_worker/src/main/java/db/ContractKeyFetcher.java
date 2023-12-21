package db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.*;


public class ContractKeyFetcher {
    
    public String  getKey(String filename)
    {

            String key="";
        try
        {
             Statement st=new DBDriver().getDriverStatement();

            String query="Select * from assignedinfo where assignedfilename='"+filename+"' ";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                
               key=rs.getString(6);
            
            }
          
    
        }
                       
        catch(Exception e)
        {
            System.out.println("Exception at ContractKeyFetcher Class is: "+e);
            
        }
       
      return key;
    }
 


}
