/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jofrantoba.httpfcm;

/**
 *
 * @author jofrantoba
 */
public enum EnumEndPoint {
    FCMHTTPS("https","https://fcm.googleapis.com/fcm/send",443),
	FCMXMPPMODEPROD("xmpp","fcm-xmpp.googleapis.com",5235),
	FCMXMPPMODEDEV("xmpp","fcm-xmpp.googleapis.com",5236);
    private final String protocol;
    private final String urlEndPoint;
    private final Integer port;

    EnumEndPoint(String protocol,String urlEndPoint,Integer port){
        this.protocol=protocol;
        this.urlEndPoint=urlEndPoint;
        this.port=port;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getUrlEndPoint() {
        return urlEndPoint;
    }

    public Integer getPort() {
        return port;
    }
    
    
}
