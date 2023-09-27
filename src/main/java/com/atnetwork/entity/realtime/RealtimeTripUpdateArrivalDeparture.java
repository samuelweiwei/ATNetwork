/**
 * 
 */
package com.atnetwork.entity.realtime;

/**
 * @author weiwei
 *
 */
public class RealtimeTripUpdateArrivalDeparture {
	private short delay;
	private long time;
	private short uncertainty;
	public short getDelay() {
		return delay;
	}
	public void setDelay(short delay) {
		this.delay = delay;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public short getUncertainty() {
		return uncertainty;
	}
	public void setUncertainty(short uncertainty) {
		this.uncertainty = uncertainty;
	}
}
