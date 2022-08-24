package com.asset.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	@Entity
	@Table(name="Desktops")
	public class DesktopEntity {
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
		String procurement_Reference;
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
		public void setAsset_Name(String assetName) {
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
		public String getProcurement_Reference() {
			return procurement_Reference;
		}
		public void setProcurement_Reference(String procurement_Reference) {
			this.procurement_Reference = procurement_Reference;
		}
		@Override
		public String toString() {
			return "DesktopEntity [gGID=" + gGID + ", category=" + category + ", asset_Type=" + asset_Type
					+ ", serialNumber=" + serialNumber + ", assetName=" + assetName + ", make_model=" + make_model
					+ ", allocation_Ticket_Number=" + allocation_Ticket_Number + ", allocation_Date=" + allocation_Date
					+ ", assigned_To=" + assigned_To + ", surrender_Ticket_Number=" + surrender_Ticket_Number
					+ ", surrender_Release_Date=" + surrender_Release_Date + ", Location=" + Location + ", status="
					+ status + ", comments=" + comments + ", procurement_Reference=" + procurement_Reference + "]";
		}
		public DesktopEntity(int gGID, String category, String asset_Type, String serialNumber, String assetName,
				String make_model, String allocation_Ticket_Number, LocalDate allocation_Date, String assigned_To,
				String surrender_Ticket_Number, LocalDate surrender_Release_Date, String location, String status,
				String comments, String procurement_Reference) {
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
			this.procurement_Reference = procurement_Reference;
		}
		public DesktopEntity() {
			super();
		}
		
		
		
		
	}

