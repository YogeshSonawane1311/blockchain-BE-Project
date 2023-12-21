
package db;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MySQLTableUpdater {
    
    
    public boolean updateProviderinfo(Statement st, String name, String email, String mob,String balance,String uid,String pass, String pin)
    {
        boolean flag;
        
        try
        {
                       
           String query="Update providerinfo set name='"+name+"',email='"+email+"',mobile='"+mob+"',initial_balance='"+balance+"',password='"+pass+"',pin='"+pin+"' where userid='"+uid+"'";
            System.out.println("query: "+query);           
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
            
            
        }
        
        catch(SQLException e)
        {
            System.out.println("Exception in MySQLTableUpdater Class in updateProviderinfo(): "+e);
            flag=false;
        }
        
        
        return flag;
    }
    
    
}
