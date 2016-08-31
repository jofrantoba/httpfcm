package com.jofrantoba.httpfcm;

import java.io.IOException;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;

public class Tester3 {

	public static void main(String arg[]) throws SmackException, IOException, XMPPException{
		int contador=0;
		if(true){
			contador=contador+1;
		NotificationMessage not=new NotificationMessage();
		not.setTargetTo("dWWgMtn5GBA:APA91bGSiN7a2LVuuHl3ydyTZtjCdNd2fnAQNJ9QMSaAEN_Tu4cZKK8ViFU4CH0nDY7rZ1Xt372G7huI3DonnvZFUdBALzkPGaBZRCFwB5nbq2KpYUMb9zzFTthZ1gLC-1wmu00oxEky");
		not.setOptionMessageId(java.util.UUID.randomUUID().toString());
		not.setOptionRestrictedPackageName("com.indiana");
    	not.setOptionPriority(10);
    	AndroidNotificationPayLoad payLoad=new AndroidNotificationPayLoad();
    	payLoad.setTitle("INDIANT");
    	payLoad.setBody("HOLA MUNDO");
    	payLoad.setColor("#ffffff");
    	payLoad.setSound("default");
    	
    	DataPayLoad dataPayLoad=new DataPayLoad();
    	dataPayLoad.add("idNotification", 121354654);    	
    	not.setPayLoadData(dataPayLoad.buildPayLoad());
    	not.setPayLoadNotification(payLoad.buildPayLoadAndroid());
    	String projectId="728034091568";
		String serverKey="AIzaSyCKB1cXore70KWHAswFW7kqRKoF_e_tXng";				
		XmppFcmNotification2.initXmppDeveloper(true,projectId,serverKey,not);  
		
		}
		
	}
	
}
