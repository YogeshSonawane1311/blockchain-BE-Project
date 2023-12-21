/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cw_provider;

import java.io.FileInputStream;


public class TextFileReader {
    
    public String getTextFileContent(String path)
    {
        String textContent="";
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
                textContent=sb.toString();
            f.close();

        }
        catch(Exception ex)
        {
            System.out.println("Exception in class TextFileReader Class in getTextFileContent(): "+ex);
        }
        
        return textContent;
    }
    
}
