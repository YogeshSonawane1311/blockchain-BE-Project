/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rcc;

import java.util.ArrayList;

public class Divider

{
ArrayList divideString(String ms)
    {


     char ch[]=ms.toCharArray();

String temp="";
int count =0;

ArrayList mas=new ArrayList();
     for(int i=0;i<ms.length();i++)
     {

    String st=Character.toString(ch[i]);
    temp=temp+st;
      count++;
      if(count==10)
      {
          mas.add(temp);
          count=0;
          temp="";
      }
     }

int k=ms.length();
int m=k%10;

String pp="";
for(int i=(k-m);i<k;i++)
{
 String st1=Character.toString(ch[i]);

 pp=pp+st1;

}
mas.add(pp);

return mas;

}
}
