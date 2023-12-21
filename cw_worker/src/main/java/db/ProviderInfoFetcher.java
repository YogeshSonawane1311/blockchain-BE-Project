package db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;

public class ProviderInfoFetcher {
    
    public String  getProviderInfo(String name)
    {

        String mob="";
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from providerinfo where userid='"+name+"'";
            ResultSet rs=st.executeQuery(query);
     //taskid, providername, enckey, filename, taskdescription, notask, taskdeadline, taskamt, securitydeposit, status       
            if(rs.next())
            {
              mob=rs.getString(2);
           
            }
         
        }
                    
        catch(Exception e)
        {
            System.out.println("Exception in ProviderInfoFetcher Class is: "+e);
            
        }
       
      return mob;
    }
 


}
