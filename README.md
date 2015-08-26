# AWSTrycorder-Java
A cross account data collector for AWS

My other project in C#,  the EC2 event Monitor, started life to accomplish one task:
 Go through all our AWS Accounts, and all the regions, and look for systems that were scheduled to reboot.
 
 Once that was done, I realized that I could leverage the AWS Toolkit to collect a lot more information than just EC2 Instance Data.
 
 I added routines to list Users and relevant information about them also across accounts, then ditto for our S3 buckets.
 I also added some sloppy code to allow context menus to SSH or SCP to Linux systems on AWS.
 
 Anyway,  that project is still in use,  but it was getting a little sloppy after so many updates to what it could do.  
 I decided to start over and rewrite the program in Java, both to learn Java and to have a more widely usable tool.  
 This is that new program.
 
 Things are moving a bit slowly, as I am trying to design a more efficient architecture that will allow the program to run
 with or without a GUI, and to allow JMX to configure the app on the fly.  I also REALLY need to learn how to implement MVC to
 make it more responsive, and to get it to run multithreaded as the C# version is starting to bog down with all the information 
 it needs to collect.  I am hoping once I get the design down,  I should be able to port the C# data collectors over fairly quickly.
