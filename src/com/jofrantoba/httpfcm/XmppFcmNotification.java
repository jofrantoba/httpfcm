package com.jofrantoba.httpfcm;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;

import javax.net.ssl.SSLSocketFactory;

import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.ReconnectionManager.ReconnectionPolicy;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.RosterListener;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration.Builder;
import org.jivesoftware.smackx.gcm.packet.GcmPacketExtension;

public class XmppFcmNotification  implements ConnectionListener{
	private String user;
	private String key;
	public static ReconnectionManager conectionManager;
	private Random random = new Random();
	private static XMPPTCPConnection xmppTcpConection;
	
	public XmppFcmNotification(String projectId,String serverKey){
		this.user=projectId + "@gcm.googleapis.com";
		this.key=serverKey;
	}
	
	public void initXmppDeveloper(boolean debugger) throws SmackException, IOException, XMPPException{
		if(xmppTcpConection==null){
		Builder xmppTcpBuilder=XMPPTCPConnectionConfiguration.builder();
		xmppTcpBuilder.setHost(EnumEndPoint.FCMXMPPMODEDEV.getUrlEndPoint());
		xmppTcpBuilder.setPort(EnumEndPoint.FCMXMPPMODEDEV.getPort());
		xmppTcpBuilder.setServiceName(EnumEndPoint.FCMXMPPMODEDEV.getUrlEndPoint());
		xmppTcpBuilder.setUsernameAndPassword(user, key);
		xmppTcpBuilder.setSendPresence(false);
		xmppTcpBuilder.setDebuggerEnabled(debugger);
		xmppTcpBuilder.setConnectTimeout(999999999);
		xmppTcpBuilder.setSocketFactory(SSLSocketFactory.getDefault());
		XMPPTCPConnectionConfiguration xmppTcpConectionConfig=xmppTcpBuilder.build();		
		xmppTcpConection=new XMPPTCPConnection(xmppTcpConectionConfig);	
		//xmppTcpConection.addConnectionListener(this);  
		conectionManager=ReconnectionManager.getInstanceFor(xmppTcpConection);
		conectionManager.isAutomaticReconnectEnabled();
		conectionManager.setReconnectionPolicy(ReconnectionPolicy.RANDOM_INCREASING_DELAY);
		xmppTcpConection.connect();
		xmppTcpConection.login();	
		}
	}
	
	public void initXmppProduction(boolean debugger) throws XMPPException, SmackException, IOException{		
		if(xmppTcpConection==null){
		Builder xmppTcpBuilder=XMPPTCPConnectionConfiguration.builder();
		xmppTcpBuilder.setHost(EnumEndPoint.FCMXMPPMODEPROD.getUrlEndPoint());
		xmppTcpBuilder.setPort(EnumEndPoint.FCMXMPPMODEPROD.getPort());
		xmppTcpBuilder.setServiceName(EnumEndPoint.FCMXMPPMODEPROD.getUrlEndPoint());
		xmppTcpBuilder.setUsernameAndPassword(user, key);
		xmppTcpBuilder.setSendPresence(false);
		xmppTcpBuilder.setDebuggerEnabled(debugger);
		xmppTcpBuilder.setConnectTimeout(999999999);		
		xmppTcpBuilder.setSocketFactory(SSLSocketFactory.getDefault());
		XMPPTCPConnectionConfiguration xmppTcpConectionConfig=xmppTcpBuilder.build();			
		xmppTcpConection=new XMPPTCPConnection(xmppTcpConectionConfig);		
		//xmppTcpConection.addConnectionListener(this);  
		conectionManager=ReconnectionManager.getInstanceFor(xmppTcpConection);
		conectionManager.isAutomaticReconnectEnabled();
		conectionManager.setReconnectionPolicy(ReconnectionPolicy.RANDOM_INCREASING_DELAY);
		xmppTcpConection.connect();
		xmppTcpConection.login();	
		}
	}
	
	public void sendNotificationXmpp(NotificationMessage notification) throws NotConnectedException{
		GcmPacketExtension packet= new GcmPacketExtension(notification.buildMessageNotification());
    	Message mensaje=new Message();
    	mensaje.addExtension(packet);
    	mensaje.setStanzaId(getRandomMessageId());   
    	xmppTcpConection.sendStanza(mensaje);
    	
	}
	
	public String getRandomMessageId() {
        return "m" + Long.toString(random.nextLong());
    }

	@Override
	public void authenticated(XMPPConnection arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connected(XMPPConnection arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getConnectionCounter());
		System.out.println(arg0.getPacketReplyTimeout());
		System.out.println(arg0.getLastStanzaReceived());
		System.out.println(arg0.getStreamId());		
	}

	@Override
	public void connectionClosed() {
		// TODO Auto-generated method stub
		System.out.println("conexion cerrada");
	}

	@Override
	public void connectionClosedOnError(Exception arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getLocalizedMessage());
	}

	@Override
	public void reconnectingIn(int arg0) {
		// TODO Auto-generated method stub
		try{
		xmppTcpConection.connect();
		xmppTcpConection.login();
		}catch(Exception ex){
			System.out.println(ex.getLocalizedMessage());
		}
	}

	@Override
	public void reconnectionFailed(Exception arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getLocalizedMessage());
	}

	@Override
	public void reconnectionSuccessful() {
		// TODO Auto-generated method stub
		System.out.println("conecto");
	}
		 
	
}
