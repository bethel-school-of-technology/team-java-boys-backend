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
		public int getauthorID() {
			return this.authorID;
		}
		public void setAuthorId(int authorID) {
			this.authorID = authorID;
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
