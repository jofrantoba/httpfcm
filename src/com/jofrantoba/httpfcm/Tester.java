/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.httpfcm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.ExponentialBackOff;

/**
 *
 * @author jofrantoba
 */
public class Tester {
	private final static String FIREBASE_SERVER_KEY="AIzaSy00000000000000000000000Xng";
    public static void main(String arg[]) throws IOException{     	
    	NotificationMessage not=new NotificationMessage();   
    	not.setTargetTo("/topics/news");
    	not.setOptionRestrictedPackageName("com.package");
    	not.setOptionPriority(10);    	
    	AndroidNotificationPayLoad payLoad=new AndroidNotificationPayLoad();
    	payLoad.setTitle("JOFRANTOBA");
    	payLoad.setBody("HOLA MUNDO");
    	payLoad.setColor("#ffffff");
    	DataPayLoad dataPayLoad=new DataPayLoad();
    	dataPayLoad.add("idNotification", 121354654);
    	not.setPayLoadData(dataPayLoad.buildPayLoad());
    	not.setPayLoadNotification(payLoad.buildPayLoadAndroid());    	
    	FcmConection cnx=new FcmConection(FIREBASE_SERVER_KEY,EnumContentType.JSON.getValue());    	
    	System.out.println(cnx.sendNotificationHttp(not));
    }
}
