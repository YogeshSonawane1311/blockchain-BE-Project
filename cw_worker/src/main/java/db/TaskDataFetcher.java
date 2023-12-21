package db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import db.DBDriver;
import java.sql.*;
import java.util.ArrayList;

public class TaskDataFetcher {
    
    public ArrayList getDetails(String taskid)
    {

//bidid, uid, itemname, date, time, itprice, bidamt, itemmagename       
        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBDriver().getDriverStatement();

            String query="Select * from taskinfo where taskid='"+taskid+"'";
            ResultSet rs=st.executeQuery(query);
     //taskid, providername, enckey, filename, taskdescription, notask, taskdeadline, taskamt, securitydeposit, status       
            if(rs.next())
            {
             ar.add(rs.getString(1));    
            ar.add(rs.getString(2));
            ar.add(rs.getString(5));
            ar.add(rs.getString(6));
            ar.add(rs.getString(7));
            ar.add(rs.getString(8));
            ar.add(rs.getString(9));
            
            }
            
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception in TaskDataFetcher Class is: "+e);
            
        }
       
      return ar;
    }
 


}
