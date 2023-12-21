package db;



import java.sql.*;

public class LoginChecker {


    public boolean checkLogin(Statement st, String uid, String pass)
    {
        boolean flag;

        try
        {

            
            String query="Select * from providerinfo where userid='"+uid+"'and password='"+pass+"'";

            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
             flag=true;   
            }
            
            else
            {
                flag=false;
            }
          

        }

        catch(SQLException e)
        {
            System.out.println("Exception in Login Checker Class in checkLogin() is: "+e);
            flag=false;
        }




        return flag;
    }

}
