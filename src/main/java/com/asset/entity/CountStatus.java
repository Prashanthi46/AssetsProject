package com.asset.entity;


public class CountStatus {
private String assetType;
private String status;
private int count;
public String getAssetType() {
	return assetType;
}
public void setAssetType(String assetType) {
	this.assetType = assetType;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public CountStatus(String assetType, String status, int count) {
	super();
	this.assetType = assetType;
	this.status = status;
	this.count = count;
}
public CountStatus() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "CountStatus [assetType=" + assetType + ", status=" + status + ", count=" + count + "]";
}



	
	
	
}
