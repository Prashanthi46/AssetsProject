package com.asset.entity;


	import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	@Entity
	@Table(name="Mobiles")
	public class MobileEntity {
		@Id
		int gGID;
		@NotNull(message="category is required")
		@Column(name="category")
		String category;
		
		@NotNull(message="serialnumber is required")
		@Column(unique=true)
		String serialNumber;
		String asset_Type;
		String assetName;
		String make_model;
		String allocation_Ticket_Number;
		LocalDate allocation_Date;
		String assigned_To;
		String surrender_Ticket_Number;
		LocalDate surrender_Release_Date;
		String Location;
		String status;
		String comments;
		String imei_Number;
		String did_Number;
		String function;
		String team;
		String os_andriod_Version;
		String mac_Address;
		
		public int getgGID() {
			return gGID;
		}
		public void setgGID(int gGID) {
			this.gGID = gGID;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getAsset_Type() {
			return asset_Type;
		}
		public void setAsset_Type(String asset_Type) {
			this.asset_Type = asset_Type;
		}
		
		public String getSerialNumber() {
			return serialNumber;
		}
		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}
		public String getAssetName() {
			return assetName;
		}
		public void setAssetName(String assetName) {
			this.assetName = assetName;
		}
		public String getMake_model() {
			return make_model;
		}
		public void setMake_model(String make_model) {
			this.make_model = make_model;
		}
		public String getAllocation_Ticket_Number() {
			return allocation_Ticket_Number;
		}
		public void setAllocation_Ticket_Number(String allocation_Ticket_Number) {
			this.allocation_Ticket_Number = allocation_Ticket_Number;
		}
		public LocalDate getAllocation_Date() {
			return allocation_Date;
		}
		public void setAllocation_Date(LocalDate allocation_Date) {
			this.allocation_Date = allocation_Date;
		}
		public String getAssigned_To() {
			return assigned_To;
		}
		public void setAssigned_To(String assigned_To) {
			this.assigned_To = assigned_To;
		}
		public String getSurrender_Ticket_Number() {
			return surrender_Ticket_Number;
		}
		public void setSurrender_Ticket_Number(String surrender_Ticket_Number) {
			this.surrender_Ticket_Number = surrender_Ticket_Number;
		}
		public LocalDate getSurrender_Release_Date() {
			return surrender_Release_Date;
		}
		public void setSurrender_Release_Date(LocalDate surrender_Release_Date) {
			this.surrender_Release_Date = surrender_Release_Date;
		}
		public String getLocation() {
			return Location;
		}
		public void setLocation(String location) {
			Location = location;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public String getImei_Number() {
			return imei_Number;
		}
		public void setImei_Number(String imei_Number) {
			this.imei_Number = imei_Number;
		}
		public String getDid_Number() {
			return did_Number;
		}
		public void setDid_Number(String did_Number) {
			this.did_Number = did_Number;
		}
		public String getFunction() {
			return function;
		}
		public void setFunction(String function) {
			this.function = function;
		}
		public String getTeam() {
			return team;
		}
		public void setTeam(String team) {
			this.team = team;
		}
		public String getOs_andriod_Version() {
			return os_andriod_Version;
		}
		public void setOs_andriod_Version(String os_andriod_Version) {
			this.os_andriod_Version = os_andriod_Version;
		}
		public String getMac_Address() {
			return mac_Address;
		}
		public void setMac_Address(String mac_Address) {
			this.mac_Address = mac_Address;
		}
		public MobileEntity(int gGID, String category, String asset_Type, String serialNumber, String assetName,
				String make_model, String allocation_Ticket_Number, LocalDate allocation_Date, String assigned_To,
				String surrender_Ticket_Number, LocalDate surrender_Release_Date, String location, String status,
				String comments, String imei_Number, String did_Number, String function, String team,
				String os_andriod_Version, String mac_Address) {
			super();
			this.gGID = gGID;
			this.category = category;
			this.asset_Type = asset_Type;
			this.serialNumber = serialNumber;
			this.assetName = assetName;
			this.make_model = make_model;
			this.allocation_Ticket_Number = allocation_Ticket_Number;
			this.allocation_Date = allocation_Date;
			this.assigned_To = assigned_To;
			this.surrender_Ticket_Number = surrender_Ticket_Number;
			this.surrender_Release_Date = surrender_Release_Date;
			Location = location;
			this.status = status;
			this.comments = comments;
			this.imei_Number = imei_Number;
			this.did_Number = did_Number;
			this.function = function;
			this.team = team;
			this.os_andriod_Version = os_andriod_Version;
			this.mac_Address = mac_Address;
		}
		public MobileEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "MobileEntity [gGID=" + gGID + ", category=" + category + ", asset_Type=" + asset_Type
					+ ", serialNumber=" + serialNumber + ", assetName=" + assetName + ", make_model=" + make_model
					+ ", allocation_Ticket_Number=" + allocation_Ticket_Number + ", allocation_Date=" + allocation_Date
					+ ", assigned_To=" + assigned_To + ", surrender_Ticket_Number=" + surrender_Ticket_Number
					+ ", surrender_Release_Date=" + surrender_Release_Date + ", Location=" + Location + ", status="
					+ status + ", comments=" + comments + ", imei_Number=" + imei_Number + ", did_Number=" + did_Number
					+ ", function=" + function + ", team=" + team + ", os_andriod_Version=" + os_andriod_Version
					+ ", mac_Address=" + mac_Address + "]";
		}
		
		
		
		
		
		
		
		
	}



