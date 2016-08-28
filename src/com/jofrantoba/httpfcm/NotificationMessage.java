package com.jofrantoba.httpfcm;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
/**
*
* @author jofrantoba
*/
public class NotificationMessage {	
	private final static Integer MINTIMETOLIVE=0;
	private final static Integer MAXTIMETOLIVE=2419200;
	private String message;
	private Collection<String> registrationIds;
	private String to;	
	private String condition;
	private String collapseKey;
	private Integer priority;
	private Boolean contentAvailable;
	private Boolean delayWhileIdle;
	private Integer timeToLive;	
	private String restrictedPackageName;
	private Boolean dryRun;
	private String data;
	private String notification;	
	private JSONObject jsonObjectData;
	private JSONObject jsonObjectNotification;
	
	public void setTargetRegistrationIds(Collection<String> registrationIds){
		this.registrationIds=registrationIds;		
	}
	
	public void setTargetTo(String to){
		this.to=to;		
	}
	
	public void setTargetCondition(String condition){
		this.condition=condition;		
	}
	
	public void setOptionCollapseKey(String collapseKey){
		this.collapseKey=collapseKey;		
	}
	
	public void setOptionPriority(Integer priority){
		priority = Integer.valueOf(Math.min(priority.intValue(), 10));
		priority = Integer.valueOf(Math.max(priority.intValue(), 0));
		this.priority=priority;		
	}
	
	public void setOptionContentAvailable(Boolean contentAvailable){
		this.contentAvailable=contentAvailable;		
	}
	
	public void setOptionDelayWhileIdle(Boolean delayWhileIdle){
		this.delayWhileIdle=delayWhileIdle;		
	}
	
	public void setOptionTimeToLive(Integer timeToLive){
		if(timeToLive<MINTIMETOLIVE){
			timeToLive=MINTIMETOLIVE;
		}else if(timeToLive>MAXTIMETOLIVE){
			timeToLive=MAXTIMETOLIVE;
		}
		this.timeToLive=timeToLive;		
	}
	
	public void setOptionRestrictedPackageName(String restrictedPackageName){
		this.restrictedPackageName=restrictedPackageName;		
	}
	
	public void setOptionDryRun(Boolean dryRun){
		this.dryRun=dryRun;		
	}
	
	public void setPayLoadData(JSONObject jsonObjectData){
		this.jsonObjectData=jsonObjectData;
		this.data=jsonObjectData.toString();		
	}
	
	public void setPayLoadNotification(JSONObject jsonObjectNotification){
		this.jsonObjectNotification=jsonObjectNotification;
		this.notification=jsonObjectNotification.toString();		
	}	
	
	public Collection<String> getRegistrationIds() {
		return registrationIds;
	}

	public String getTo() {
		return to;
	}

	public String getCondition() {
		return condition;
	}

	public String getCollapseKey() {
		return collapseKey;
	}

	public Integer getPriority() {
		return priority;
	}

	public Boolean getContentAvailable() {
		return contentAvailable;
	}
	
	public Boolean getDelayWhileIdle() {
		return delayWhileIdle;
	}

	public Integer getTimeToLive() {
		return timeToLive;
	}

	public String getRestrictedPackageName() {
		return restrictedPackageName;
	}

	public Boolean getDryRun() {
		return dryRun;
	}

	public String getData() {
		return data;
	}

	public String getNotification() {
		return notification;
	}

	public String buildMessageNotification(){
		JSONObject obj = new JSONObject();
		if(registrationIds!=null && registrationIds.size()>0){
			obj.put(EnumNotificationMessage.targetRegistrationIds.getTag(), registrationIds);			
		}else if(to!=null && !to.isEmpty()){
			obj.put(EnumNotificationMessage.targetTo.getTag(), to);			
		}
		if(condition!=null && !condition.isEmpty()){
			obj.put(EnumNotificationMessage.targetCondition.getTag(), condition);					
		}
		if(collapseKey!=null && !collapseKey.isEmpty()){
			obj.put(EnumNotificationMessage.optionCollapseKey.getTag(), collapseKey);							
		}
		if(priority>=0 && priority<=10){
			obj.put(EnumNotificationMessage.optionPriority.getTag(),priority);									
		}
		if(contentAvailable!=null){
			obj.put(EnumNotificationMessage.optionContentAvailable.getTag(),contentAvailable);		
		}
		if(delayWhileIdle!=null){
			obj.put(EnumNotificationMessage.optionDelayWhileIdle.getTag(),delayWhileIdle);				
		}
		if(timeToLive!=null){
			obj.put(EnumNotificationMessage.optionTimeToLive.getTag(),timeToLive);						
		}
		if(restrictedPackageName!=null && !restrictedPackageName.isEmpty()){
			obj.put(EnumNotificationMessage.optionRestrictedPackageName.getTag(), restrictedPackageName);											
		}
		if(dryRun!=null){
			obj.put(EnumNotificationMessage.optionDryRun.getTag(), dryRun);								
		}
		if(dryRun!=null){
			obj.put(EnumNotificationMessage.optionDryRun.getTag(), dryRun);								
		}
		if(data!=null && !data.isEmpty()){
			obj.put(EnumNotificationMessage.payloadData.getTag(), jsonObjectData);													
		}	
		if(notification!=null && !notification.isEmpty()){
			obj.put(EnumNotificationMessage.payloadNotification.getTag(), jsonObjectNotification);													
		}		
		message=obj.toString();
		return message;
	}

	public String getMessage() {
		return message;
	}
	
	public Collection<StatusIds> viewStatusIds(Collection<Result> resultados){
		Collection<StatusIds> statusIds=new ArrayList<StatusIds>();
		ArrayList<String> ids=(ArrayList<String>)registrationIds;
		ArrayList<Result> results=(ArrayList<Result>)resultados;
		for(int i=0;i<results.size();i++){
			Result result=results.get(i);
			String id=ids.get(i);
			if(result.getError()!=null && !result.getError().isEmpty()){
				StatusIds bean=new StatusIds();
				bean.setId(id);
				bean.setStatusMessage(result.getError());
				bean.setIsCorrect(false);
				statusIds.add(bean);
			}else if(result.getMessage_id()!=null && !result.getMessage_id().isEmpty()){
				StatusIds bean=new StatusIds();
				bean.setId(id);
				bean.setStatusMessage(result.getMessage_id());
				bean.setIsCorrect(true);	
				bean.setNewId(result.getRegistration_id());
				statusIds.add(bean);
			}
		}
		return statusIds;
	}
}
