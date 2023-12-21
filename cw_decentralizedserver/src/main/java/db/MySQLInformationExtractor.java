/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import java.util.LinkedList;

public class MySQLInformationExtractor {
    
     public LinkedList getProviderInformation(Statement st, String tablename, String userid)
    {

       LinkedList providerinfo=new LinkedList();

        try
        {

                  
            String query="Select *from"+" "+tablename+" "+"where userid='"+userid+"'";

            ResultSet rs=st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int column_count = rsmd.getColumnCount();
            
             
             while(rs.next())
            {
                for (int i = 1; i <=column_count; i++) 
                {
                    providerinfo.add(rs.getString(i));
                }
                          
            }
             
            
        }

        catch(SQLException e)
        {
            System.out.println("Exception in MySQLnformationExtractor Class is in getProviderInformation() is: "+e);

        }

       return providerinfo;
    }
    
      
}
