
package db;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DataTableCreator {
    
    public boolean createTableWithPrimaryKey(Statement st, String tablename, LinkedList attributes, String pkey)
    {
        boolean flag;
        
         try
        {
              String attribute="";
               for (int i = 0; i <attributes.size(); i++) 
               {
                  attribute=attribute+attributes.get(i)+" "+"VARCHAR(100)"+",";
               }
                 attribute=attribute+" PRIMARY KEY ("+pkey+"))";
                  attribute=attribute.substring(0, attribute.length()-1);
                   attribute=attribute.trim();
                  
               String query="CREATE TABLE IF NOT EXISTS"+" "+tablename+"("+attribute+")";
               
             
               
               int x=st.executeUpdate(query);
                
               flag = x>0;
            
            }            
             
        
        catch(SQLException e)
        {
            System.out.println(e+"Exception in DataTableCreator Class is: ");
            flag=false;
        }
        
        
        return flag;
    }
    
    public boolean createTableWithoutPrimaryKey(Statement st, String tablename, LinkedList attributes)
    {
        boolean flag;
        
         try
        {
              String attribute="";
               for (int i = 0; i <attributes.size(); i++) 
               {
                  attribute=attribute+attributes.get(i)+" "+"VARCHAR(100)"+",";
               }
                  
                  attribute=attribute.substring(0, attribute.length()-1);
                  attribute=attribute.trim();
                  
               String query="CREATE TABLE IF NOT EXISTS"+" "+tablename+"("+attribute+")";
               
             
               
               int x=st.executeUpdate(query);
                
               flag = x>0;
            
            }            
             
        
        catch(SQLException e)
        {
            System.out.println(e+"Exception in DataTableCreator Class is in createTableWithoutPrimaryKey(): ");
            flag=false;
        }
        
        
        return flag;
    }
}
