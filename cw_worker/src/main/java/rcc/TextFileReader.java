/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rcc;

import java.io.FileInputStream;


public class TextFileReader
{


    public String readTempFile(String inputfname)
    {
        

StringBuffer st1=new StringBuffer();

     try
     {

       // String inputfname="C://image1.txt";
           // String inputfname="nbproject/sam.prop";


       FileInputStream f1=new FileInputStream(inputfname);

       //System.out.println("File name is "+fname);
       int x=0;
     char c=' ';
        do
        {  x=f1.read();

           if( x!=-1)

                c=(char)x;
                    st1.append(c);

        }while(x!=-1 );

       f1.close();
     
     }
      catch(Exception e)

       {
       }


String fcont=st1.toString();
String dd=fcont.substring(0, fcont.length()-1);
return dd;
    }
}
