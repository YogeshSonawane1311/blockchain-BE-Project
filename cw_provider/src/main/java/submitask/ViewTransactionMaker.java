/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submitask;


import db.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ViewTransactionMaker {
    
    
    public ArrayList getAssignDetails(String providername)
    {
        
        
        
        ArrayList data=new ArrayList();
       
        try
        {
            
            java.sql.Statement st=new DBConnection().getDBConnection();

           
            String query="Select * from assignedinfo where puname='"+providername+"' ";

            ResultSet rs1=st.executeQuery(query);
 //taskid, puname, wuname, assignedfilename, submittedfilename, mkey, assigneddatetime, submitdatetime, rewards, penalty, status   
            while(rs1.next())
            {
                ArrayList temp=new ArrayList();
                
                String taskid=rs1.getString(1);
                 String puname=rs1.getString(2);
                String wuname=rs1.getString(3);
                String assignedfilename=rs1.getString(4);
                String submittedfilename=rs1.getString(5);
                String mkey=rs1.getString(6);
                String assigneddatetime=rs1.getString(7);
                String submitdatetime=rs1.getString(8);
               String rewards=rs1.getString(9);
                String penalty=rs1.getString(10);
                String status=rs1.getString(11);
                
                
                temp.add(taskid);
                temp.add(puname);
                temp.add(wuname);
                temp.add(assignedfilename);
                temp.add(submittedfilename);
                 temp.add(mkey);
                temp.add(assigneddatetime);
                temp.add(submitdatetime); 
                 temp.add(rewards);
                temp.add(penalty);
                temp.add(status);
                
                data.add(temp);
            
            }

          
            System.out.println("datac "+data);
        }
           
        catch(Exception e)
        {
            System.out.println("Exception in ViewTransactionMaker Class in : "+e);

        }
  return data;
    }    
}
