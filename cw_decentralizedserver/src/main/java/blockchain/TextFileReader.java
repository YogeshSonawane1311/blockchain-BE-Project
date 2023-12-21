/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import java.io.FileInputStream;


public class TextFileReader {
    
    public String getContent(String path)
    {
        String cont="";
        try
        {
            FileInputStream f= new FileInputStream(path);
            int x=0;
            StringBuffer sb=new StringBuffer();
            do
            {
                x=f.read();
                if(x!=-1)
                {
                    char ch=(char)x;
                    sb.append(ch);

                }
            }while(x!=-1);
                cont=sb.toString();
            f.close();

        }
        catch(Exception ex)
        {
            System.out.println("Exception in class TextFIleReader---####"+ex);
        }
        
        return cont;
    }
    
}
