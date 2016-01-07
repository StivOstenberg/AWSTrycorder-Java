/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awstrycorder;
import com.amazonaws.auth.AWSCredentials;
import java.lang.management.ManagementFactory;
import javax.management.*;
import javax.management.ObjectInstance;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.swing.JFrame;

/**
 *
 * @author s.ostenberg
 */
public class AWSTrycorder {

    	private static final String CONNECTOR_ADDRESS_PROPERTY = "com.sun.management.jmxremote.localConnectorAddress";
        
        static JMXConnector myJMXconnector = null;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, NotCompliantMBeanException, MBeanRegistrationException {
       //Process Args
              //Config File Location
        
              //AWS Creds File Location
        
        
              // GUI or CLI
        
        //Load ConfigFile
        
        //Get the MBean server
        
        
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        //Register der MBean
        TrycorderEngine mBean = new TrycorderEngine();
        ObjectName name = new ObjectName("com.stiv.jmx:type=TrycorderEngine");
        mbs.registerMBean(mBean, name);
        

//Launch GUI if necessary
        AWSTrycorderGUI frame = new AWSTrycorderGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setTitle("AWS Trycorder - Java");
        
    }
    
}
