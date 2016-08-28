/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.httpfcm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.json.JSONObject;

import com.google.gson.Gson;

/**
 *
 * @author jofrantoba
 */
public class Tester {
	private final static String FIREBASE_SERVER_KEY="BAIzaStyCKB1cXore70sKWHAswFW7kqRKoF_e_tXngrz";
    public static void main(String arg[]) throws IOException{     	
    	NotificationMessage not=new NotificationMessage();   
    	//not.setTargetTo("e1iMVdE_JMM:APA91bH-a08EINdsPgBTyxOz3NOkFlPPnYBpufF9Rs_9f4gSWntR2AprYXOovkdsYnZj_RuqkmE9U9VHTbmi-iyZTfCstdsMb4ECu6d_xya6YOtWIvBt4Ll0Hi0vx3IbAeZoLc995awC");
    	//not.setTargetTo("xx");
    	Collection<String> ids=new ArrayList<String>();
    	ids.add("d2hwq8l1N3o:APA91bGkr9mPMbwcJoLItlzjWvRK2j0haXBewjjZhSsw6X7pUjBMZwtnIU3yJUmlRC0Vc5ILTEB9Y3jmtwR61s9B1Exl6CGf8CoGP_TXODRHIruxGHn92ePNv4CFps47DN7DzkWPqw6L");
    	ids.add("agdfgdfgdfg");
    	ids.add("dqPOhjyY91o:APA91bEnw3MZY9nwHcyOjKgJGBUTZNUZ-9Wb8UUH2IczZhRFdTT7IExZSuokKCOZM1PQacrPWk0Lt8vzafR4-HKYounTTyUoGmn4bUATktu5o0brVG27EkGyFrMgwD0WQyi5xer5mRM3");
    	ids.add("agdfgdfgdfgdsadas");
    	ids.add("agdfgdfgdfgdsadascxzczx");
    	ids.add("eqjwMgiAk_Y:APA91bF7WHn9ZrKBMdLGtUIpUGuuSLSiKiTbCXPim-3QSeNi3nnug1f0gUHjYHWWRW8XPQ4zAuwws9UDy-jLVxu4BScPW06B6UalrjTDdNp42ddM2tiYERvcVCd-TZ9b3oU6y0Lg_qlG");
    	ids.add("e1iMVdE_JMM:APA91bH-a08EINdsPgBTyxOz3NOkFlPPnYBpufF9Rs_9f4gSWntR2AprYXOovkdsYnZj_RuqkmE9U9VHTbmi-iyZTfCstdsMb4ECu6d_xya6YOtWIvBt4Ll0Hi0vx3IbAeZoLc995awC");
    	ids.add("e1iMVdE_JMM:APA91bH-a08EINdsPgBTyxOz3NOkFlPPnYBpufF9Rs_9f4gSWntR2AprYXOovkdsYnZj_RuqkmE9U9VHTbmi-iyZTfCstdsMb4ECu6d_xya6YOtWIvBt4Ll0Hi0vx3IbAeZoLc995awC");
    	
    	not.setTargetRegistrationIds(ids);
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
    	FcmConection cnx=new FcmConection(FIREBASE_SERVER_KEY,EnumContentType.JSON.getValue());    	    	
    	DataResponse dataResponse=(DataResponse)cnx.sendNotificationHttp(not).get(EnumResponse.RESPONSEMESSAGE.getValue());
    	Collection<StatusIds> status=not.viewStatusIds(dataResponse.getResults());
    	Iterator<StatusIds> i=status.iterator();
    	while(i.hasNext()){
    		StatusIds bean=i.next();
    		System.out.print(bean.getId()+"\t");    
    		System.out.print(bean.getStatusMessage()+"\t");
    		System.out.println(bean.getIsCorrect());
    	}
    	System.out.println(dataResponse);    	
    }
}

