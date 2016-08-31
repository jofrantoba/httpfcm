package com.jofrantoba.httpfcm;

import java.util.Collection;

import org.json.JSONObject;
/**
*
* @author jofrantoba
*/
public class IosNotificationPayLoad {
	private String title;
	private String body;
	private String sound;
	private String badge;
	private String clickAction;
	private String bodyLocKey;
	private Collection<String> bodyLocArgs;
	private String titleLocKey;
	private Collection<String> titleLocArgs;
	private String payload;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}	
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public String getClickAction() {
		return clickAction;
	}
	public void setClickAction(String clickAction) {
		this.clickAction = clickAction;
	}
	public String getBodyLocKey() {
		return bodyLocKey;
	}
	public void setBodyLocKey(String bodyLocKey) {
		this.bodyLocKey = bodyLocKey;
	}
	public Collection<String> getBodyLocArgs() {
		return bodyLocArgs;
	}
	public void setBodyLocArgs(Collection<String> bodyLocArgs) {
		this.bodyLocArgs = bodyLocArgs;
	}
	public String getTitleLocKey() {
		return titleLocKey;
	}
	public void setTitleLocKey(String titleLocKey) {
		this.titleLocKey = titleLocKey;
	}
	public Collection<String> getTitleLocArgs() {
		return titleLocArgs;
	}
	public void setTitleLocArgs(Collection<String> titleLocArgs) {
		this.titleLocArgs = titleLocArgs;
	}
	
	public JSONObject buildPayLoadIos(){
		JSONObject obj = new JSONObject();
		if(title!=null && !title.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitle.getTag(), title);					
		}
		if(body!=null && !body.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBody.getTag(), body);					
		}
		if(sound!=null && !sound.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramSound.getTag(), sound);					
		}
		if(badge!=null && !badge.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBadge.getTag(), badge);					
		}
		if(clickAction!=null && !clickAction.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramClickAction.getTag(), clickAction);					
		}
		if(bodyLocKey!=null && !bodyLocKey.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBodyLocKey.getTag(), bodyLocKey);					
		}
		if(bodyLocArgs!=null && !bodyLocArgs.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBodyLocArgs.getTag(), bodyLocArgs);					
		}
		if(titleLocKey!=null && !titleLocKey.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitleLocKey.getTag(), titleLocKey);					
		}
		if(titleLocArgs!=null && !titleLocArgs.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitleLocArgs.getTag(), titleLocArgs);					
		}
		payload=obj.toString();
		return obj;
	}
	public String getPayload() {
		return payload;
	}
}
