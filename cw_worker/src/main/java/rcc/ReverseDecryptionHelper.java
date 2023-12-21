/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rcc;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ReverseDecryptionHelper
{
    public String startDecryption(String ens,String key)
    {
        
        
        
//  for decryptyion give strign as ens
             Divider d1=new Divider();
        ArrayList mas1=d1.divideString(ens);

      //  System.out.println("Mas 1 is "+mas1);


String ens1="";
for(int i=0;i<mas1.size();i++)
{
int n=i+1;



String str=(String)mas1.get(i);
 Derotate     rr=new Derotate();
 String str1=rr.deRotateString(str, n);

 //System.out.println("Detorate String is "+str1);


 ReverseDecryption  re=new ReverseDecryption();
 String dstr=re.getReverseDe(str1,key);

//System.out.println("Decrypted String is "+dstr);

 ens1=ens1+dstr;
        }
return ens1;
    }
}
