/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import db.UpdateKeyMaker;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import keygeneration.CurrentDate;
import keygeneration.CurrentTime;
import keygeneration.KeyGenSupporter;
import keygeneration.MD5;
import util.Datakeeper;


public class BlockchainUpdator {
    
   public void createBlockchain(ArrayList fileinfo )
    {
     
         String headkey="";
         for (int i = 0; i < fileinfo.size(); i++) 
            {
                    
                ArrayList row=(ArrayList) fileinfo.get(i);
                String filename=(String) row.get(1);
                String filepath=Datakeeper.path+"//"+filename;
                        
                String content=new TextFileReader().getContent(filepath);
                
               // System.out.println("Content in  BlockchainUpdate "+content);
                content=content+headkey;
                String hashkey=new MD5().MDfive(content);
                headkey =new KeyGenSupporter().getKey(hashkey);
              
                        
            }
        
                    
             String date = new CurrentDate().getDate();
             String time = new CurrentTime().getTime();
             String dt = date + "-" + time;
        System.out.println(" Before BlockchainUpdator ");
              UpdateKeyMaker um = new UpdateKeyMaker();
             if (um.UpdateKeyInfo(dt, headkey)) 
             {
                          //  JOptionPane.showMessageDialog(null, "New headKey Updated Sucessfully");
             }
        
        

    }
    
}
