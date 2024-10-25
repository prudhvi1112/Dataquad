package com.dataquad.model;

public class AdminDto 
{
	
		private String email;

		private String firstName;
	
		private String lastName;

		private long mobileNumber;

		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		@Override
		public String toString() {
			return "AdminDto [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", mobileNumber=" + mobileNumber + "]";
		}
		public AdminDto(String email, String firstName, String lastName, long mobileNumber) {
			super();
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.mobileNumber = mobileNumber;
		}
		public AdminDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	
		
		
		
		
		
		
		

	}



