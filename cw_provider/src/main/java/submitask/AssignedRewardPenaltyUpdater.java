/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submitask;


import db.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class AssignedRewardPenaltyUpdater {
    
     public boolean updateProvider(String rewards,String penalty,String taskid)
    {

        boolean flag=true;
        try
        {
           Statement st=new DBConnection().getDBConnection();
                       String query = "update  assignedinfo set rewards='"+rewards+"', penalty='"+penalty+"' where taskid='"+taskid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("Exception in AssignedRewardPenaltyUpdater Class is:  "+ex);
            flag=false;
        }

        return flag;
    }
    
}
