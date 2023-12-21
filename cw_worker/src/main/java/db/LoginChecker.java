/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.*;


public class LoginChecker {

    public boolean doLogin(String username,String password)
    {
boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crowdsourcing?autoReconnect=true&useSSL=false","root","root");
            Statement st=conn.createStatement();

            String query="Select *from workerinfo  where username='"+username+"'and password='"+password+"'";
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
            
                conn.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception in LoginChecker Class is: "+e);
            flag=false;
        }

return flag;

    }
}
