/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rcc;


public class Rotate
{
public String rotateString(String  str,int n)
    {

   n=n%10;

if(str.length()!=10)
{
    n=str.length();
}

      
   

//   System.out.println("String lenght is "+str.length());
//System.out.println("Value of N is  "+n);


//we are all indians, and we are all
//tq b                    tq b


// mahabharat   n=3
// ratmahabha
   
 char ch[]=str.toCharArray();

        

       String  pp="";

         int k=str.length()-n;
         for(int j=str.length()-n;j<str.length();j++)
         {


             String pr=Character.toString(ch[j]);
        pp=pp+pr;


         }

         for(int i=0;i<str.length()-n;i++)
         {


             String pr=Character.toString(ch[i]);
        pp=pp+pr;


         }



         return (pp);






   }



}
