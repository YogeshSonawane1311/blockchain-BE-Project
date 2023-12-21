package db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class TaskInfoFetcher {
    
    public ArrayList getDetails(String taskid)
    {
        Statement st=null;
        ArrayList ar= new ArrayList();
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crowdsourcing?autoReconnect=true&useSSL=false","root","root");
            st=conn.createStatement();

            String query="Select * from taskinfo where taskid='"+taskid+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
             ar.add(rs.getString(4)); 
             ar.add(rs.getString(5));
            }
            
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at TaskInfoFetcher Class is: "+e);
            
        }
       
      return ar;
    }
 


}
