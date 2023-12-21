/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class MySQLDBInserter {
    
     public boolean insertData(Statement st, String tablename,LinkedList values)
    {
        boolean flag;
        
        try
        {
            
            String value="";
            for (int i = 0; i <values.size(); i++) 
            {
                value=value+"'"+values.get(i)+"'"+",";
            }
            
            value=value.substring(0, value.length()-1);
            value=value.trim();
                       
            System.out.println("values: "+values);
            String query="Insert into"+" "+tablename+" "+"values"+"("+value+")";
            System.out.println("query: "+query);
            
                   
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
            
          
            
        }
        
        catch(SQLException e)
        {
            System.out.println("Exception in MySQLDBInserter Class is: "+e);
            flag=false;
        }
        
        
        
        
        return flag;
    }
     
    }
