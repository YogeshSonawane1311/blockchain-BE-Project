/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Statement;


public class AccessInserter {
    
     public boolean insertAccessinfo(String workeruname,String taskid,String providername ,String datetime,String status)
    {

        boolean flag=true;
        try
        {
           Statement st=new DBDriver().getDriverStatement();
            String query = "insert into accessrequestinfo values ('"+workeruname+"','"+taskid+"','"+providername+"','"+datetime+"','"+status+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("Exception in AccessInserter Class is:  "+ex);
            flag=false;
        }

        return flag;
    }
    
}
