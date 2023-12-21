package submitask;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class RewardPenaltyFetcher {
    
    public ArrayList getDetails(String username)
    {

        ArrayList ar= new ArrayList();
        try
        {
            
            Statement st=new DBConnection().getDBConnection();

            String query="Select * from workerinfo where username='"+username+"'";
            ResultSet rs=st.executeQuery(query);
                if(rs.next())
            {
        
            ar.add(rs.getString(9));   
            ar.add(rs.getString(10));

           
            

            }
            
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at RewardPenaltyFetcher Class is: "+e);
            
        }
       
      return ar;
    }
 


}
