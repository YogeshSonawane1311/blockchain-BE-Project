/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cw_decentralizedserver;


import db.AssignedInserter;
import blockchain.Blockchain;
import blockchain.BlockchainAlpha;
import blockchain.BlockchainUpdator;
import blockchain.FileNameFetcher;
import blockchain.Sorter;
import blockchain.TextFileReader;
import blockchain.TextFileWriter;
import db.UpdateKeyMaker;
import blockchain.WorkerNumFetcher;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import keygeneration.CurrentDate;
import keygeneration.CurrentTime;
import keygeneration.KeyGenSupporter;
import keygeneration.MD5;
import rcc.ReverseDecryptionHelper;
import rcc.ReverseEncryptionHelper;
import util.Datakeeper;




public class DW_ServerReceiver extends Thread {
public String finmkey = "";
    public void run() {
        String main = "";
        String finmsg="";
        
        
         ArrayList asfileinfo=new  ArrayList();
        System.out.println("Recevier Starter");
        try {
            ServerSocket s = new ServerSocket(1254);
            while (true) {
                Socket ss = s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String ms = dis.readUTF();
                
                System.out.println("ms: "+ms);
                
                if(ms.startsWith("upload"))
                {

                File folder = new File(Datakeeper.path);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                File lf[] = folder.listFiles();

                if (lf.length == 0) 
                {
                    String mm[] = ms.split("@");
                    String filename = mm[1];
                    String str = mm[2];
                    System.out.println("Received file name is " + filename);
                    /// System.out.println("str is "+str);
                    String p = Datakeeper.path + "//" + filename;
                    //String p="D:/File Server";
                    TextFileWriter tfw = new TextFileWriter();
                    if (tfw.getContent(p, str)) {
                        System.out.println(filename + " is stored Successfully");

                    } else {
                        System.out.println(" Error in Storing " + filename);
                    }

                    String content = new TextFileReader().getContent(p);
                    String hashkey = new MD5().MDfive(content);
                    String key = new KeyGenSupporter().getKey(hashkey);

                    String date = new CurrentDate().getDate();
                    String time = new CurrentTime().getTime();
                    String dt = date + "-" + time;
                    
                    System.out.println("date: "+dt);
                    System.out.println("key: "+key);

                    UpdateKeyMaker um = new UpdateKeyMaker();
                    if (um.UpdateKeyInfo(dt, key)) {
                        //  JOptionPane.showMessageDialog(null, "Key Updated Sucessfully");
                        
                        System.out.println("Key updated successfully");
                    }

                    String msg = "stored safely";
                    DCServerSender sers = new DCServerSender();
                    sers.sendData(msg, Datakeeper.providerip);

                    System.out.println("Message Sent to Provider " + msg);
                    
                    String tx= finmsg+"\n"+msg+filename;
                    
                    StartServerFrame.jTextArea1.setText(tx);

                }  

                else 
                {

                    ArrayList fileinfo = new FileNameFetcher().getFileDetails();
                     asfileinfo = new Sorter().getSortedList(fileinfo);
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println(asfileinfo);

                    Blockchain bc = new Blockchain();
                    String filename="";
                    if (bc.createBlockchain(asfileinfo)) 
                    {

                        String mm[] = ms.split("@");
                         filename = mm[1];
                        String str = mm[2];
                        System.out.println("Received file name is " + filename);
                        /// System.out.println("str is "+str);
                        String newpath = Datakeeper.path + "//" + filename;
                        //String p="D:/File Server";
                        TextFileWriter tfw = new TextFileWriter();
                        if (tfw.getContent(newpath, str)) 
                        {
                            System.out.println(filename + " is stored Successfully");

                        } else 
                        {
                            System.out.println(" Error in   " + filename);
                        }

                        new BlockchainAlpha().createBlockchain(asfileinfo, newpath);
                        

                        String msg = "stored safely";
                        DCServerSender sers = new DCServerSender();
                        sers.sendData(msg, Datakeeper.providerip);

                        System.out.println("Message Sent to Provider " + msg);
                        
                        String tx= finmsg+"\n"+msg+filename;
                        
                        StartServerFrame.jTextArea1.setText(tx);

                    } else
                    {
                        String msg = "not stored and Data is unsafe";
                        DCServerSender sers = new DCServerSender();
                        sers.sendData(msg, Datakeeper.providerip);

                        System.out.println("Message Sent to Provider " + msg);
                        
                        String tx= finmsg+"\n"+msg+filename;
                        StartServerFrame.jTextArea1.setText(tx);
                        
                    }
                
                }
                }
                
                 else if(ms.startsWith("smartcontract"))
                {
                    
                    System.out.println("Welcome to smart Contract");
                    
                    String mm[] = ms.split("#");
                    
                    String taskid=mm[1];
                    String filename=mm[2];
                    String puname=mm[3];
                    String wuname=mm[4];
                    String psign=mm[5];
                    String wsign=mm[6];
                    
                    System.out.println("Task id "+taskid+" File name "+filename+" puname "+puname+" wuname "+wuname+" psign "+psign+" wsign "+wsign);
                    
                     String newpath = Datakeeper.path + "//" + filename;
                     String content=new blockchain.TextFileReader().getContent(newpath);
                      String findcr=new ReverseDecryptionHelper().startDecryption(content, psign);
                      
                     TextFileWriter tfw = new TextFileWriter();
                        if (tfw.getContent(newpath, findcr)) 
                        {
                            System.out.println(filename + "Decrypted  Successfully");

                        } else 
                        {
                            System.out.println(" Error in   " + filename);
                        }
                    String newcontent=new blockchain.TextFileReader().getContent(newpath);
                    
                    String mkey=psign+wsign;
                    String hashkey=new MD5().MDfive(mkey);
                    finmkey =new KeyGenSupporter().getKey(hashkey);
                    
                    
                    
                    String finenc=new ReverseEncryptionHelper().startEncryption(newcontent, finmkey);
                    
                    
                        if (tfw.getContent(newpath, finenc)) 
                        {
                            System.out.println(filename + " Encrypted By Mutual Sign Successfully");

                        } else 
                        {
                            System.out.println(" Error in   " + filename);
                        }
                        
                         ArrayList fileinfo = new FileNameFetcher().getFileDetails();
                     ArrayList aasfileinfo = new Sorter().getSortedList(fileinfo);
                     
                          new BlockchainUpdator().createBlockchain(aasfileinfo);
                        System.out.println("updating done");
                        
                           String dt=new CurrentDate().getDate();
                           
                           System.out.println("Current Date "+dt);
                    String sdt="empty";
                    String reward="0";
                    String pen="0";
                    String status="assigned";
                    String submitfilename="empty";
                    System.out.println("+_+_++_+_+_+_+_+_+_+_+_+_+_+_");
              AssignedInserter ass=    new AssignedInserter();
              if(ass.registerAssignedinfo(taskid, puname, wuname, filename,submitfilename, finmkey, dt, sdt, reward, pen, status))
                      {
                          
                         // JOptionPane.showMessageDialog(null,"Task has been Assigned");
                          
                          
                      }
              else
              {
                  System.out.println("error");
              }
                          
                          
                          
                          
                          
                    String wnum=new WorkerNumFetcher().getDetails(wuname);
                    String message="Dear, "+wuname+" your request has been granted for the new job by the provider "+puname+" for task id "+taskid+" ,please Access it.";
                   
                    
                    
                   
                      System.out.println("&&&&&&  "+wnum);
                   
                    
                 //   new sendSMS().sendText(message, wnum);
                    
                }
                
                
                
                
                else if(ms.startsWith("download"))
                {
                    //downloadsubmittedfile
                    
                    
                    System.out.println(" Inised downloadsubmittedfile ");
                     String mm[] = ms.split("#");
                    
                     System.out.println(" Inser DSSS "+ms);
                     
                    String filname=mm[1];
                    String newpath = Datakeeper.submitpath + "//" + filname;
                    String content=new blockchain.TextFileReader().getContent(newpath);
                    content = new ReverseDecryptionHelper().startDecryption(content, finmkey);
                   String str="submit";
                   
                   String mainstr=str+"#"+filname+"#"+content;
                    System.out.println("sssssssssssssssssssssss "+mainstr);
                    
                    DCServerSender d=new DCServerSender();
                    d.sendData(mainstr, Datakeeper.providerip);
                   
                    
                    
                    
                    
                    
                    
                    
                }
                
                
                
                
                
                }
                
       
        } catch (Exception e) {
            System.out.println("Exception in DW_ServerReceiver Class is: "+e);

        }

    }
}
