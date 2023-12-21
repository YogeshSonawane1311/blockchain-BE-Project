/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submitask;


import db.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ViewAssignMaker {
    
    
    public ArrayList getAssignDetails()
    {
        
        ArrayList data=new ArrayList();
        String status="Submitted";
        try
        {
           java.sql.Statement st=new DBConnection().getDBConnection();

           
            String query="Select * from assignedinfo where status='"+status+"' ";

            ResultSet rs1=st.executeQuery(query);
 //taskid, puname, wuname, filename, mkey, assigneddatetime, submitdatetime, rewards, penalty, status    
            while(rs1.next())
            {
                ArrayList temp=new ArrayList();
                
                String taskid=rs1.getString(1);
                String wuname=rs1.getString(3);
                String filename=rs1.getString(5);
                String assigneddatetime=rs1.getString(7);
                String submitdatetime=rs1.getString(8);
               
                
                
                temp.add(taskid);
                temp.add(wuname);
                temp.add(filename);
                temp.add(assigneddatetime);
                temp.add(submitdatetime); 
   
                
                data.add(temp);
            
            }

          
            System.out.println("datac "+data);
        }
           
        catch(Exception e)
        {
            System.out.println("Exception at ViewAssignMaker Class in getAssignDetails() is: "+e);

        }

      //return data;
        return data;
    }    
}
