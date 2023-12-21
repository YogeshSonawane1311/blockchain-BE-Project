package db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.ArrayList;

public class WorkerDataFetcher {
    
    public ArrayList getDetails(String name)
    {


        ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crowdsourcing?autoReconnect=true&useSSL=false","root","root");
            Statement st=conn.createStatement();

            String query="Select * from workerinfo where username='"+name+"'";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {

            ar.add(rs.getString(1));
            ar.add(rs.getString(2));
            ar.add(rs.getString(3));
            ar.add(rs.getString(4));
            ar.add(rs.getString(5));
            ar.add(rs.getString(6));
            
           
            

            }
            conn.close();
            System.out.println("ar is  "+ar);
    
        }
                     
        catch(Exception e)
        {
            System.out.println("Exception in WorkerDataFetcher Class is: "+e);
            
        }
       
      return ar;
    }
 


}
