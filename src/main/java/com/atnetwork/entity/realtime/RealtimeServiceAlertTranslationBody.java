/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeServiceAlertTranslationBody {
	private String text;
	private String language;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
