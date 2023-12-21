/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submitask;

import db.DBConnection;
import java.sql.Statement;


public class WorkRewardPenaltyUpdater {
    
     public boolean updateProvider(String rewards,String penalty,String wname)
    {

        boolean flag=true;
        try
        {
           Statement st=new DBConnection().getDBConnection();

           //name, mobileno, emailid, username, password, balance
            String query = "update  workerinfo set rewards='"+rewards+"', penalty='"+penalty+"' where username='"+wname+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("Exception at WorkRewardPenaltyUpdater Class in updateProvider () is: "+ex);
            flag=false;
        }

        return flag;
    }
    
}
