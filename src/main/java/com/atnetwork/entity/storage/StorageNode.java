/**
 * 
 */
package com.atnetwork.entity.storage;

/**
 * @author weiwei
 *
 */
public class StorageNode {
	
	public static final String nodetype_vehicle = "vehicle";
	public static final String nodetype_stop = "stop";
	
	private String nodetype; //"vehicle", "stop"
	private StorageUnionStopsBean susb;
	private StorageUnionVehicleBean svb;
	public StorageNode(String ns) {
		switch (ns) {
			case nodetype_stop:
				this.nodetype = nodetype_stop;
				susb = new StorageUnionStopsBean();
				break;
			case nodetype_vehicle:
				this.nodetype = nodetype_vehicle;
				svb = new StorageUnionVehicleBean();
				break;
			default:
		}
	}
	
	public String getNodetype() {
		return nodetype;
	}
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
	public StorageUnionStopsBean getSusb() {
		return susb;
	}
	public void setSusb(StorageUnionStopsBean susb) {
		this.susb = susb;
	}
	public StorageUnionVehicleBean getSvb() {
		return svb;
	}
	public void setSvb(StorageUnionVehicleBean svb) {
		this.svb = svb;
	}
}
