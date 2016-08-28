package com.jofrantoba.httpfcm;

public enum EnumResponse {
	STATUSCODE("Integer","STATUSCODE"),
	STATUSMESSAGE("String","STATUSMESSAGE"),
	RESPONSEMESSAGE("DataResponse","RESPONSEMESSAGE");
	private final String value;
	private final String type;
	EnumResponse(String type,String value){
        this.value=value;
        this.type=type;
    }

    public String getValue() {
        return value;
    }
}
