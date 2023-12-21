/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cw_worker;

import java.awt.Dimension;
import java.awt.Toolkit;
import netops.ServerReceiver;


public class Cs_worker {

  
    public static void main(String[] args) {
        // TODO code application logic here
        new ServerReceiver().start();
        WorkerLoginFrame plog=new WorkerLoginFrame();
        plog.setVisible(true);
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        plog.setSize(d);
        
    }
    
}
