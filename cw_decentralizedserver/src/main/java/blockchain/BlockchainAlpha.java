/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import db.UpdateKeyMaker;
import java.util.ArrayList;
import keygeneration.CurrentDate;
import keygeneration.CurrentTime;
import keygeneration.KeyGenSupporter;
import keygeneration.MD5;
import util.Datakeeper;


public class BlockchainAlpha {
    
   public void createBlockchain(ArrayList fileinfo , String newfilepath)
    {
     
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
         
             String content=new TextFileReader().getContent(newfilepath);
              content=content+headkey;
              String hashkey=new MD5().MDfive(content);
              headkey =new KeyGenSupporter().getKey(hashkey);
                
                    System.out.println(" Current headkey "+headkey);
                    
                    
             String date = new CurrentDate().getDate();
             String time = new CurrentTime().getTime();
             String dt = date + "-" + time;

              UpdateKeyMaker um = new UpdateKeyMaker();
             if (um.UpdateKeyInfo(dt, headkey)) 
             {
                            // JOptionPane.showMessageDialog(null, "Key Updated Sucessfully");
             }
  
        

    }
    
}
