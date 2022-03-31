package com.sprint1db.entities;

	public class Applicant {
		
		private long id;
		private String name;
		private String phoneNumber;
		private String emailId;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		@Override
		public String toString() {
			return "Applicant [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
		}
		public Applicant(long id, String name, String phoneNumber, String emailId) {
			super();
			this.id = id;
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.emailId = emailId;
		}
		public Applicant(long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Applicant() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Applicant(long id, String phoneNumber, String emailId) {
			super();
			this.id = id;
			this.phoneNumber = phoneNumber;
			this.emailId = emailId;
		}
		
		

	}
