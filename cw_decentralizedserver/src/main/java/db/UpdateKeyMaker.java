

package db;
import db.DBConnection;
import java.sql.*;


public class UpdateKeyMaker {

     public boolean UpdateKeyInfo(String datetime,String key )
    {
boolean flag=true;
        try
        {
            String type="blockchainterminalkey";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crowdsourcing?autoReconnect=true&useSSL=false","root","root");
            Statement st=conn.createStatement();

            String query="update blockchaininfo set  datetime='"+datetime+"' , terminalkey='"+key+"' where type='"+type+"' " ;
            
            
            
            System.out.println("blockinfo query: "+query);
            
            
            int x=st.executeUpdate(query);
            if(x>0)
            {
                flag=true;
            }
            else

            {
                flag=false;
 }
            
               
        }
        catch(Exception e)
        {
            System.out.println("Exception in UpdateKeyMaker Class in "+e);
            flag=false;
        }

return flag;

    }

}
