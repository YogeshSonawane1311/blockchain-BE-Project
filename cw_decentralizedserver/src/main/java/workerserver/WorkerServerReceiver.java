/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workerserver;


import blockchain.TextFileReader;
import blockchain.TextFileWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import util.Datakeeper;



public class WorkerServerReceiver extends Thread {

    public void run() {
        String main = "";
        String finmsg="";
        
        
         ArrayList asfileinfo=new  ArrayList();
        System.out.println("Recevier Starter");
        try {
            ServerSocket s = new ServerSocket(12346);
            while (true) {
                Socket ss = s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String ms = dis.readUTF();
                
                 if(ms.startsWith("download"))
                {
                     String mm[] = ms.split("#");
                    
                    String filname=mm[1];
                    
                    System.out.println("Filename WorkerServerReceiver "+filname);
                    String newpath = Datakeeper.path + "//" + filname;
                    String content=new TextFileReader().getContent(newpath);
                    String str="file";
                    String mainstr=str+"#"+filname+"#"+content;
                    
                    WorkerServerSender wss=new WorkerServerSender();
                    wss.sendData(mainstr, Datakeeper.workerip);
                    
                    
                    
                }
                 else if(ms.startsWith("submit"))
                 {
                            File folder = new File(Datakeeper.submitpath);
                      if (!folder.exists()) {
                          folder.mkdirs();
                      }

                     
                     
                     String mm[] = ms.split("#");
                     String filename=mm[1];
                     String con=mm[2];
                     String newpath = Datakeeper.submitpath + "//" + filename;
                     TextFileWriter tf=new TextFileWriter();
                     tf.getContent(newpath, con);
                     
                    // JOptionPane.showMessageDialog(null, "File Received Successfully from Worker");
                     
                 }
                
                
                
                
                
//                  RecvFrame.fname=filename;
//                  RecvFrame.con=str;
//             DCServerSender serv= new DCServerSender();
//             serv.sendData(concat, DataKeeper.ip);
//             SearchResultFrame.concat=concat;
//             SearchResultFrame mf = new SearchResultFrame();
//             Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//             mf.setVisible(true);
//             mf.setSize(d);
            }
        } catch (Exception e) {

        }

    }
}
