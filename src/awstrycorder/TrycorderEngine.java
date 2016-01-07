/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awstrycorder;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import java.util.ArrayList;
import java.util.HashMap;



/**
 *
 * @author s.ostenberg
 */
public class TrycorderEngine implements TrycorderEngineMBean{
    private String TrycorderConfigFile="";
    private String AWSCredentialsFile="";
    private boolean ShowUI = true;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setrerun(int minutes_to_next_run) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList GetProfiles() {
        ArrayList<String> dalist = new ArrayList<String>(Credentials.keySet());
        return dalist;
    }
    
}
