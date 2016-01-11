/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awstrycorder;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * A class containing data structures and variables used by the Trycorder
 * @author s.ostenberg
 */
public class Dilithium { 
    //If writing to the console, adding these variables to a string will change font color.
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m"; 
private static final String CONNECTOR_ADDRESS_PROPERTY = "com.sun.management.jmxremote.localConnectorAddress";

public static void GimmeABean(String Bean2Get)
    {
        JMXConnector myJMXconnector = null;
        javax.management.ObjectInstance myObj= null;
        VirtualMachineDescriptor TARGETDESCRIPTOR = null ;
                    //The following code grabs a list of running VMs and sees if they match our target--------------------------------------
    Map<String, VirtualMachine> result = new HashMap<>();
    List<VirtualMachineDescriptor> list = VirtualMachine.list();
    List<VirtualMachineDescriptor> MATCHINGLIST = new ArrayList<>();
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    Boolean gotit = false;
    String listofjvs = "";
    MBeanServerConnection myJMXConnection = null;

    for (VirtualMachineDescriptor vmd : list) 
    {
         String desc = vmd.toString();
                            try {
                        result.put(desc, VirtualMachine.attach(vmd));
                        String DN = vmd.displayName();
                        if (DN.contains(Bean2Get) ) {
                                TARGETDESCRIPTOR = vmd;
                                gotit = true;
                                MATCHINGLIST.add(vmd);   
                        } 
                    } catch (IOException | AttachNotSupportedException e) 
                    {
                        
                    }
    
    }//End of for vmd loop
    if (MATCHINGLIST.size()>1)
    {
    //It is already running.  Dont want another.
    }
    
    try {
        myJMXconnector = getLocalConnection(VirtualMachine.attach(TARGETDESCRIPTOR));// Connects to the process containing our beans
    } catch (Exception ex) {
        Logger.getLogger(Dilithium.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
         myJMXConnection = myJMXconnector.getMBeanServerConnection(); //Connects to the MBean server for that process.
    } catch (IOException ex) {
        Logger.getLogger(Dilithium.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    try {
         myObj =  myJMXConnection.getObjectInstance(ObjectName.WILDCARD);
    } catch (InstanceNotFoundException ex) {
        Logger.getLogger(Dilithium.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Dilithium.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
    
    String wehaveabean = "yay";
    //We are going to return whatever object lets us access the Trycorder MBean functions
    }


static JMXConnector getLocalConnection(VirtualMachine vm) throws Exception {
   Properties props = vm.getAgentProperties();
   String connectorAddress = props.getProperty(CONNECTOR_ADDRESS_PROPERTY);
   if (connectorAddress == null) {
      props = vm.getSystemProperties();
      String home = props.getProperty("java.home");
      String agent = home + File.separator + "lib" + File.separator + "management-agent.jar";
      vm.loadAgent(agent);
      props = vm.getAgentProperties();
      connectorAddress = props.getProperty(CONNECTOR_ADDRESS_PROPERTY);
   }
   JMXServiceURL url = new JMXServiceURL(connectorAddress);
   return JMXConnectorFactory.connect(url);
}
}
