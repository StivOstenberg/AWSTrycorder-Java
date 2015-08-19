/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awstrycorder;
import com.amazonaws.auth.AWSCredentials;
import javax.swing.JFrame;

/**
 *
 * @author s.ostenberg
 */
public class AWSTrycorder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Process Args
              //Config File Location
        
              //AWS Creds File Location
        
        
              // GUI or CLI
        //Load ConfigFile
        
        //Launch GUI if necessary
        AWSTrycorderGUI frame = new AWSTrycorderGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        
    }
    
}
