/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import java.util.ArrayList;
import keygeneration.KeyGenSupporter;
import keygeneration.MD5;
import util.Datakeeper;


public class Blockchain {
    
   public boolean createBlockchain(ArrayList fileinfo )
    {
        boolean flag=true;
         String headkey="";
         for (int i = 0; i < fileinfo.size(); i++) 
            {
                    
                ArrayList row=(ArrayList) fileinfo.get(i);
                String filename=(String) row.get(1);
                String filepath=Datakeeper.path+"//"+filename;
                        
                String content=new TextFileReader().getContent(filepath);
                content=content+headkey;
                String hashkey=new MD5().MDfive(content);
                headkey =new KeyGenSupporter().getKey(hashkey);
                
             
                
                
                        
            }
            String dbkey=new KeyFetcher().getKey();
         if(dbkey.equals(headkey))
                {
                      flag=true;
                      
                }
                else
                {
                    flag=false;
                }
        
                    System.out.println(" Current headkey "+headkey);
                    
                    
                    
        
        
        
      return flag;  
    }
    
}
