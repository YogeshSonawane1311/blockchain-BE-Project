/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import db.DBConnection;
import java.sql.*;


public class LoginChecker {

    public boolean doLogin(String username,String Password)
    {
        boolean flag=true;
        try
        {
           Statement st=new DBConnection().getDBConnection();

            String query="Select *from admininfo where username='"+username+"'and password='"+Password+"'";
            ResultSet rs=st.executeQuery(query);
        //aid, username, Password
            if(rs.next())
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
            System.out.println("Exception in loginmaker"+e);
            flag=false;
        }

return flag;

    }
}
