package com.yardsalebe.controllers;

import javax.persistence.*;
import java.time.*;

@Entity(name="Post")
public class Post {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int ID;
		private String userName;
		private LocalDateTime timeStamp;
		private String streetAddress;
		private String city;
		private String state;
		private String zip;
		
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getStreetAddress() {
			return streetAddress;
		}
		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getuserName() {
			return userName;
		}
		public void setuserName(String userName) {
			this.userName = userName;
		}
		public LocalDateTime getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(LocalDateTime timeStamp) {
			this.timeStamp = timeStamp;
		}
}
