package com.jofrantoba.httpfcm;

import java.io.IOException;
import java.util.Random;

import javax.net.ssl.SSLSocketFactory;

import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration.Builder;
import org.jivesoftware.smackx.gcm.packet.GcmPacketExtension;

public class Tester1 {

	public static void main(String arg[]) throws SmackException, IOException, XMPPException{
		int contador=0;
		while(true){
			contador=contador+1;
		NotificationMessage not=new NotificationMessage();
		//not.setTargetTo("dWWgMtn5GBA:APA91bGSiN7a2LVuuHl3ydyTZtjCdNd2fnAQNJ9QMSaAEN_Tu4cZKK8ViFU4CH0nDY7rZ1Xt372G7huI3DonnvZFUdBALzkPGaBZRCFwB5nbq2KpYUMb9zzFTthZ1gLC-1wmu00oxEky");
		not.setTargetTo("e1iMVdE_JMM:APA91bH-a08EINdsPgBTyxOz3NOkFlPPnYBpufF9Rs_9f4gSWntR2AprYXOovkdsYnZj_RuqkmE9U9VHTbmi-iyZTfCstdsMb4ECu6d_xya6YOtWIvBt4Ll0Hi0vx3IbAeZoLc995awC");
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
		XmppFcmNotification xmpp=new XmppFcmNotification(projectId,serverKey);
    	xmpp.initXmppDeveloper(true);
    	xmpp.sendNotificationXmpp(not);
    	
		}
	}
	
}
