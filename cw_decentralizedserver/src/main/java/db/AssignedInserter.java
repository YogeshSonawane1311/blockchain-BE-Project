/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class AssignedInserter {
    
     public boolean registerAssignedinfo(String taskid,String puname,String wuname,String filename,String submitfilename,String mkey,String assigneddatetime,String submitdatetime,String rewards,String penalty,String status)
    {
        
        System.out.println("inside AssignedInserter ");
//taskid, puname, wuname, filename, mkey, taskdescrip, assigneddatetime, submitdatetime, rewards, penalty, status
        boolean flag=true;
        try
        {
           Statement st=new DBConnection().getDBConnection();
            String query = "insert into assignedinfo values ('"+taskid+"','"+puname+"','"+wuname+"','"+filename+"','"+submitfilename+"','"+mkey+"',  '"+assigneddatetime+"','"+submitdatetime+"','"+rewards+"', '"+penalty+"', '"+status+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
    
}
