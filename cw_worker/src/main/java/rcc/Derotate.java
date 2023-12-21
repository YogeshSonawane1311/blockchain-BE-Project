/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rcc;


public class Derotate
{


    public String deRotateString(String pp,int  n)
    {

n=n%10;

if(pp.length()!=10)
{
    n=pp.length();
}

       String  pp1="";
          char ch1[]=pp.toCharArray();
         for(int j=0;j<n;j++)
         {

             String pr=Character.toString(ch1[j]);
        pp1=pp1+pr;

         }

 String  pp2="";
         for(int i=n;i<pp.length();i++)
         {

             String pr=Character.toString(ch1[i]);
        pp2=pp2+pr;

         }
String fin=pp2+pp1;

        

return fin;


    }

}
