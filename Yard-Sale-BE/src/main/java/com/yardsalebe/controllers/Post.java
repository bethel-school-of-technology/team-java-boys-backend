package com.yardsalebe.controllers;

import javax.persistence.*;
import java.time.*;

@Entity(name="Post")
public class Post {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int ID;
		private int authorID;
		private String userName;
		private LocalDateTime timeStamp;
		private String streetAddress;
		private String city;
		private String state;
		private String zip;
		
		private String startDate;
		private String endDate;
		private String startTime;
		private String endTime;
		private String categories;


	public int getAuthorID() {
		return this.authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCategories() {
		return this.categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

		
		public String getStreetAddress() {
			return this.streetAddress;
		}
		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}
		public String getCity() {
			return this.city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return this.state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZip() {
			return this.zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public int getID() {
			return this.ID;
		}
		public void setID(int iD) {
			this.ID = iD;
		}
		public String getuserName() {
			return this.userName;
		}
		public void setuserName(String userName) {
			this.userName = userName;
		}
		public LocalDateTime getTimeStamp() {
			return this.timeStamp;
		}
		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}
}
