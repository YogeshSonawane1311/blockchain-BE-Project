/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.DBDriver;
import java.sql.Statement;


public class WorkerRegistration {
    
     public boolean insertRegistrationData(String name,String mobno,String email,String exp,String uname,String pass, String balance,String sign)
    {

        boolean flag=true;
        String reward="0";
        String penalty="0";
        
        try
        {
           Statement st=new DBDriver().getDriverStatement();
            String query = "insert into workerinfo values ('"+name+"','"+mobno+"','"+email+"','"+exp+"','"+uname+"','"+pass+"', '"+balance+"', '"+sign+"', '"+reward+"', '"+penalty+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("Exception in WorkerRegistration Class is: "+ex);
            flag=false;
        }

        return flag;
    }
    
}
