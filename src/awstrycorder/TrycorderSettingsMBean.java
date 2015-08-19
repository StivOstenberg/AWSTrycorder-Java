/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awstrycorder;

import com.amazonaws.auth.AWSCredentials;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author s.ostenberg
 */
public interface TrycorderSettingsMBean {
    
    //Preppie stuff
    public void setTrycorderConfigFile(String configfile);
    public String getTrycorderConfigFile();
    
    //Allows override of default credentials file
    public void setAWSCredentialsFile(String AWSCredFile);
    public String getAWSCredentialsFile();
    
    //Profilename to lookup Key and Secret.
    public Map<String,AWSCredentials> Credlist = new HashMap<>();
    public void AddCredential(String ProfileName, String Key, String PrivateKey);
    public void RemoveCredential(String ProfileName);
    public AWSCredentials GetCredential(String profilename);
   
    
    //UI Setup (To allow saving and loading from config file.
    
        //Selected Profiles (List accounts to show/scan)
        public Map<String,Boolean> SelectedProfiles = new HashMap<>();
        
        //Selected Regions (List regions to show/scan)
        public Map<String,Boolean> SelectedRegions = new HashMap<>();
        
        //EC2 Columns to make visible
        public Map<String,Boolean> SelectedEC2Columns = new HashMap<>();
        
        //User Columns to make visible
        public Map<String,Boolean> SelectedUserColumns = new HashMap<>();
        
        //S3 Columns to make visible
        public Map<String,Boolean> SelectedS3Columns = new HashMap<>();
    
    //ServiceSettings
        public boolean getShowUI();
        public boolean setShowUI(boolean showit);
        public int getrerun();
        
        public void setrerun(int minutes_to_next_run);
        
    //Output
        //Excel: File/S3Bucket
        //JSON:  File/S3Bucket
        //S3 Bucket
        //Dynamo
        
    //Operations:
        //Start Scan
        //Scan Started
        //Scan Running
        //Scan Ended
        //Request Terminate Scan
        //DisableEC2Scan
        //DisableIAMScan
        //DisableS3Scan
        
    //Debugging
        //ClearTimers
        //Add EC2 Time
        //Add S3 Time
        //Add Users Time
        //Get EC2,S3,IAM Times
        
    //Events
        //ScanCompleted
        //GUISettingsChanged
        //ScanStatusUpdate
        
    
        
    
}
