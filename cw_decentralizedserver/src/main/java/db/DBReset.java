/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import java.sql.Statement;


public class DBReset {
     public boolean resetDatabase()
    {
        boolean flag=true;
        try
        {
           Statement st=new DBConnection().getDBConnection();

            String query="DELETE FROM accessrequestinfo";
             int x=st.executeUpdate(query);
               
             
            if(x>0)
                flag=true;
            else
                flag=false;
                     
 }
            
        
        catch(Exception e)
        {
            System.out.println("Exception in DBReset Class is: "+e);
            flag=false;
        }

return flag;

    }
    
}
