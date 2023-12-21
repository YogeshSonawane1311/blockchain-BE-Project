/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;



import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class TableLastRowID {
    //bidid, uid, itemname, date, time, itprice, bidamt, itemmagename
    public int getLastRowId(Statement st)
    {
        int rowid=0;
        ArrayList <Integer> ids=new  ArrayList <Integer>();
        
        try
        {
       
            String query="Select *from taskinfo";
            ResultSet rs=st.executeQuery(query);
        
            while (rs.next())
            {
               String idd= rs.getString(1);
               int  biid=Integer.parseInt(idd);
               ids.add(biid);
                
            }
            if(ids.size()==0)
            {
                rowid=1;
            }
            else
            {
                int big=ids.get(0);
                for(int i=0;i<ids.size();i++)
                {
                    int aa=ids.get(i);
                    if(aa>big)
                    {
                        big=aa;
                    }
                }
                rowid=big+1;
            }
           
        }
        
        catch(Exception ex)
        {
            System.out.println("Exception in TableLastRowID in getLastRowId() is: "+ex);
            
        }
        return rowid;
    }
    
}
