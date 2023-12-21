/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cw_decentralizedserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;


public class DCServerSender {
    public void sendData(String msg,String ip)
    {
        try
        {
            Socket ss=new Socket(ip,12345);
            OutputStream os= ss.getOutputStream();
            DataOutputStream dos= new DataOutputStream(os);
            

            dos.writeUTF(msg);
            
            
            ss.close();
            os.close();
            dos.close();
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in Sender"+e);
        }
    }
}
