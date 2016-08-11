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
public enum EnumHeaderHttpFcm {
    headerProjectId("project_id"),
    headerContentType("Content-Type"),
    headerAuthorization("Authorization"),
    headerAccept("Accept"),
    headerMethodPost("POST"),
    headerEncodeUtf8("UTF-8");
	private final String header;
    EnumHeaderHttpFcm(String header){
        this.header=header;
    }
	public String getHeader() {
		return header;
	}
    
}
