/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeServiceAlertBody {
	private String cause;
	private String effect;
	private RealtimeServiceAlertHeaderText header_text;
	private RealtimeServiceAlertActivePeriod[] active_period;
	private RealtimeServiceAlertInformedEntity[] informed_entity;
	private RealtimeServiceAlertHeaderText description_text;
	private RealtimeServiceAlertHeaderText url;
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public RealtimeServiceAlertHeaderText getHeader_text() {
		return header_text;
	}
	public void setHeader_text(RealtimeServiceAlertHeaderText header_text) {
		this.header_text = header_text;
	}
	public RealtimeServiceAlertActivePeriod[] getActive_period() {
		return active_period;
	}
	public void setActive_period(RealtimeServiceAlertActivePeriod[] active_period) {
		this.active_period = active_period;
	}
	public RealtimeServiceAlertInformedEntity[] getInformed_entity() {
		return informed_entity;
	}
	public void setInformed_entity(RealtimeServiceAlertInformedEntity[] informed_entity) {
		this.informed_entity = informed_entity;
	}
	public RealtimeServiceAlertHeaderText getDescription_text() {
		return description_text;
	}
	public void setDescription_text(RealtimeServiceAlertHeaderText description_text) {
		this.description_text = description_text;
	}
	public RealtimeServiceAlertHeaderText getUrl() {
		return url;
	}
	public void setUrl(RealtimeServiceAlertHeaderText url) {
		this.url = url;
	}
}
