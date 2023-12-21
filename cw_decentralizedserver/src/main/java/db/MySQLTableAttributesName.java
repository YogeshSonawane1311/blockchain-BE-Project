
package db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MySQLTableAttributesName {
    
    
    public ArrayList getAttributesName(Statement st, String tablename) throws SQLException
    {
       
            ArrayList attributes=new ArrayList(); 
            ResultSet rs=st.executeQuery("SELECT * FROM"+" "+tablename);
            ResultSetMetaData metadata  = rs.getMetaData();
            int columnCount = metadata .getColumnCount();
            
            for (int i=1; i<=columnCount; i++) 
            {
 
            String columnName = metadata.getColumnName(i);
            attributes.add(columnName);
            }
      
      
      return attributes;
    }
    
}
