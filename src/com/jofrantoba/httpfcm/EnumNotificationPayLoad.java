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
public enum EnumNotificationPayLoad {
    paramTitle("title",false,"string",true,true),
    paramBody("body",false,"string",true,true),
    paramIcon("icon",false,"string",false,true),
    paramSound("sound",false,"string",true,true),
    paramBadge("badge",false,"string",true,false),
    paramTag("tag",false,"string",false,true),
    paramColor("color",false,"string",false,true),
    paramClickAction("click_action",false,"string",true,true),
    paramBodyLocKey("body_loc_key",false,"string",true,true),
    paramBodyLocArgs("body_loc_args",false,"JSON array as string",true,true),
    paramTitleLocKey("title_loc_key",false,"string",true,true),
    paramTitleLocArgs("title_loc_args",false,"JSON array as string",true,true);
    
    private final String tag;
    private final Boolean isRequired;
    private final String typeData;
    private final Boolean isParamIos;
    private final Boolean isParamAndroid;
    EnumNotificationPayLoad(String tag,Boolean isRequired,String typeData,Boolean isParamIos,Boolean isParamAndroid){
        this.tag=tag;
        this.isRequired=isRequired;
        this.typeData=typeData;
        this.isParamIos=isParamIos;
        this.isParamAndroid=isParamAndroid;
    }

    public String getTag() {
        return tag;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public String getTypeData() {
        return typeData;
    }

    public Boolean getIsParamIos() {
        return isParamIos;
    }

    public Boolean getIsParamAndroid() {
        return isParamAndroid;
    }
    
    
}
