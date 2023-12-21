/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submitask;


import db.DBConnection;
import java.sql.Statement;


public class UpdateClosedStatus {
    
     public boolean updateaccessinfo(String taskid)
    {

        boolean flag=true;
        String status="closed";
        try
        {
           Statement st=new DBConnection().getDBConnection();

           //name, mobileno, emailid, username, password, balance
            String query = "update accessrequestinfo set status='"+status+"' where taskid='"+taskid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("Exception in UpdateClosedStatus Class in updateaccessinfo () is: "+ex);
            flag=false;
        }

        return flag;
    }
    
          public boolean updatetaskinfo(String taskid)
    {

        boolean flag=true;
        String status="closed";
        try
        {
           Statement st=new DBConnection().getDBConnection();

           //name, mobileno, emailid, username, password, balance
            String query = "update  taskinfo set status='"+status+"' where taskid='"+taskid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("Exception in UpdateClosedStatus Class in updatetaskinfo () is "+ex);
            flag=false;
        }

        return flag;
    }
     
            public boolean updateassignedinfo(String taskid)
    {

        boolean flag=true;
        String status="closed";
        try
        {
           Statement st=new DBConnection().getDBConnection();

           //name, mobileno, emailid, username, password, balance
            String query = "update  assignedinfo set status='"+status+"' where taskid='"+taskid+"'";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;

        

        }
        catch(Exception ex)
        {
            System.out.println("Exception in UpdateClosedStatus Class in updateassignedinfo () is "+ex);
            flag=false;
        }

        return flag;
    }
          
     
}
