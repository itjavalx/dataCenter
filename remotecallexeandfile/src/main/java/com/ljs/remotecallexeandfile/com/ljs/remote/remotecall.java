package com.ljs.remotecallexeandfile.com.ljs.remote;

import jcifs.smb.NtlmPasswordAuthentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jcifs.smb.SmbFile;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/remoteCall")
public class remotecall{

    @RequestMapping("/callExe")
    public void callExe(){
        try {
            //simulateExe (file://JOHN-PC/Users/john/Desktop/simulateExe)
            //smb://Administrator:zwt1314521zw@192.168.6.138/share/
            //\\192.168.0.46\Users\john\Desktop\simulateExe_share
            SmbFile smbFile=new SmbFile("smb://simulate:@192.168.0.46//JOHN-PC/Users/john/Desktop/simulateExe/");
            for (String s : smbFile.list()) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}