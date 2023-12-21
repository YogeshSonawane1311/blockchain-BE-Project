package submitask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class SubmitDataFetcher {
    
    public ArrayList getDetails(String taskid)
    {

//bidid, uid, itemname, date, time, itprice, bidamt, itemmagename       
        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBConnection().getDBConnection();

            String query="Select * from assignedinfo where taskid='"+taskid+"'";
            ResultSet rs=st.executeQuery(query);
     //taskid, providername, enckey, filename, taskdescription, notask, taskdeadline, taskamt, securitydeposit, status       
            if(rs.next())
            {
             ar.add(rs.getString(3));    
             ar.add(rs.getString(5)); 
            ar.add(rs.getString(7));   
            ar.add(rs.getString(8));

           
            

            }
            
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at SubmitDataFetcher: "+e);
            
        }
       
      return ar;
    }
 


}
