/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBDriver 
{

    public Statement getDriverStatement() 
    {
        Statement st=null;
        try
        {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crowdsourcing?autoReconnect=true&useSSL=false","root","root");
             st=conn.createStatement(); 
        }
        catch(Exception ex)
        {
            System.out.println("Exception at DBDriver Class is: "+ex);
        }
         
        return st;
    }
}
