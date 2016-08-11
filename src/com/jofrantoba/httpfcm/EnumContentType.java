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
public enum EnumContentType {
    JSON("application/json"),
    TEXTPLAIN("application/x-www-form-urlencoded;charset=UTF-8");
    private final String value;
    EnumContentType(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
    
}
