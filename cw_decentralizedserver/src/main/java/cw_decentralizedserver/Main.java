/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw_decentralizedserver;

import admin.LoginFrame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
    
    public static void main(String args[]){
         try { 
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
            } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ignored){}

             LoginFrame mf = new LoginFrame();
             mf.setVisible(true);
             mf.setExtendedState(MAXIMIZED_BOTH);
            
        
    }
    
    
}
