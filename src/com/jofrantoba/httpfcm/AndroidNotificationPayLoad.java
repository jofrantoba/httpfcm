package com.jofrantoba.httpfcm;

import java.util.Collection;

import org.json.JSONObject;

/**
*
* @author jofrantoba
*/
public class AndroidNotificationPayLoad {
	private String title;
	private String body;
	private String icon;
	private String sound;
	private String tag;
	private String color;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	
	public JSONObject buildPayLoadAndroid(){
		JSONObject obj = new JSONObject();
		if(title!=null && !title.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTitle.getTag(), title);					
		}
		if(body!=null && !body.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramBody.getTag(), body);					
		}
		if(icon!=null && !icon.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramIcon.getTag(), icon);					
		}
		if(sound!=null && !sound.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramSound.getTag(), sound);					
		}
		if(tag!=null && !tag.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramTag.getTag(), tag);					
		}
		if(color!=null && !color.isEmpty()){
			obj.put(EnumNotificationPayLoad.paramColor.getTag(), color);					
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
