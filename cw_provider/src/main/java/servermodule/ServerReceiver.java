/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servermodule;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import submitask.ContractKeyFetcher;
import submitask.TextFileWriter;
import utility.Datakeeper;



public class ServerReceiver extends Thread{
   public void run()
    {
     String main="";
        
       
        System.out.println("Recevier Starter");
        try
        {
            ServerSocket s= new ServerSocket(12345);
            while(true)
            {
                Socket ss= s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis= new DataInputStream(is);
                String ms=dis.readUTF();
                System.out.println(ms);
                   
                Datakeeper.server_rec_string=ms;
                
                System.out.println("Message Received from Decentralized Server "+Datakeeper.server_rec_string);
                
//                
//                if(ms.startsWith("submit"))
//                {
//                  
//                    
//                    File folder = new File(Datakeeper.dpath);
//                      if (!folder.exists()) {
//                          folder.mkdirs();
//                      }
//
//                     
//                     Datakeeper.server_file_string=ms;
//                
//                    String mm[] = ms.split("#");
//                     String filename=mm[1];
//                     String con=mm[2];
//                     
//                     System.out.println(" File Name "+filename);
//                     System.out.println(" con "+con);
//                     String key=new ContractKeyFetcher().getKey(filename);
//                     
//                     String dcr=new Decryptor().startDecryption(con, key);
//                      System.out.println(" dcr "+dcr);
//                      String newpath = Datakeeper.dpath + "//" + filename;
//                     TextFileWriter tf=new TextFileWriter();
//                     if(tf.getContent(newpath, dcr))
//                     {
//                        // JOptionPane.showMessageDialog(null, "Hob Done File Downloaded Sucessfully");
//                         System.out.println("Job Done File Downloaded Sucessfully");
//                         
//                
//                     }
//                     
//                     
//                     
//                    
//                }

     }
            }
        
        catch(Exception e)
        {

        }
       
    }
}
