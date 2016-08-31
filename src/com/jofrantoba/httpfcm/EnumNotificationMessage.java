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
public enum EnumNotificationMessage {
    targetTo("to",false,"string"),
    targetRegistrationIds("registration_ids",true,"string,array"),
    targetCondition("condition",false,"string"),
    optionMessageId("message_id",true,"string"),
    optionCollapseKey("collapse_key",false,"string"),
    optionPriority("priority",false,"string"),
    optionContentAvailable("content_available",false,"JSON boolean"),
    optionDelayWhileIdle("delay_while_idle",false,"JSON boolean"),
    optionDeliveryReceiptRequest("delivery_receipt_requested",false,"JSON boolean"),
    optionTimeToLive("time_to_live",false,"JSON number"),
    optionRestrictedPackageName("restricted_package_name",false,"string"),
    optionDryRun("dry_run",false,"JSON boolean"),
    payloadData("data",false,"JSON object"),
    payloadNotification("notification",false,"JSON object")
    ;    
            
    private final String tag;
    private final Boolean isRequired;
    private final String typeData;
    EnumNotificationMessage(String tag,Boolean isRequired,String typeData){
        this.tag=tag;
        this.isRequired=isRequired;
        this.typeData=typeData;
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

       
}
