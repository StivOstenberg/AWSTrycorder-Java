/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awstrycorder;
import java.util.ArrayList;
import java.util.HashMap;
import org.joda.time.DateTime;




/**
 *
 * @author s.ostenberg
 */
public class TrycorderEngine implements TrycorderEngineMBean{
    private String TrycorderConfigFile="";
    private String AWSCredentialsFile="";
    private boolean ShowUI = true;
    private boolean ScanEC2=true;
    private boolean ScanS3=true;
    private boolean ScanIAM=true;
    private int reruninterval = 0; //If setting to autoscan at intervals of minutes.  0 means dont rescan.
    private boolean continuescanning = true; //Can be set to false to interrupt scan.

    private HashMap<String,HashMap<String,String>> Credentials = new HashMap<>();
            
    @Override
    public void setTrycorderConfigFile(String configfile) {
        TrycorderConfigFile=configfile;
    }

    @Override
    public String getTrycorderConfigFile() {
        return TrycorderConfigFile;
    }

    @Override
    public void setAWSCredentialsFile(String AWSCredFile) {
        AWSCredentialsFile=AWSCredFile;
    }

    @Override
    public String getAWSCredentialsFile() {
        String test = "";
        return AWSCredentialsFile;
    }

    @Override
    public void AddCredential(String ProfileName, String Key, String PrivateKey) {
        HashMap<String,String> KeyAndPriv = new HashMap<>();
        KeyAndPriv.put(Key, PrivateKey);
        Credentials.put(ProfileName, KeyAndPriv);
    }

    @Override
    public void RemoveCredential(String ProfileName) {
        try
        {
        Credentials.remove(ProfileName);
        }
        catch(Exception ex)
                {
                  String test = "";  
                }
    }

    @Override
    public HashMap<String,String> GetCredential(String profilename) {
        try
        {
        String rabbit = "";   
        HashMap<String,String> arf =  Credentials.get(profilename);
        
        return arf;
        }
        catch(Exception ex)
        {return(null) ;}
    }

    @Override
    public boolean getShowUI() {
        return ShowUI;
    }

    @Override
    public void setShowUI(boolean showit) {
        ShowUI = showit;
    }

    @Override
    public int getrerun() {
        return reruninterval;
    }

    @Override
    public void setrerun(int minutes_to_next_run) {
        reruninterval=minutes_to_next_run;
    }

    @Override
    public ArrayList GetProfiles() {
        ArrayList<String> dalist = new ArrayList<String>(Credentials.keySet());
        return dalist;
    }

    @Override
    public void setScan(String AWSComponent, boolean scan) {
        //Where we set our scan scope options.
        //Current Values are EC2,S3,IAM
        if(AWSComponent.equals("EC2")) ScanEC2=scan;
        if(AWSComponent.equals("S3")) ScanS3=scan;
        if(AWSComponent.equals("IAM")) ScanIAM=scan;
    }

    @Override
    public boolean StartScan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DateTime getTimeScanStarted() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isScanRunning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DateTime getTimeScanEnded() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void TerminateScan() {
        continuescanning=false;
    }

    
    public void DoScan()
    {
        
        
    }
}
