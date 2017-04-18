package com.onlinetutorialspoint.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Users {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int  userID;
    private String userName;
    private String userEmilID;
    private String Emailsubject;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date cretedDate;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmilID() {
		return userEmilID;
	}
	public void setUserEmilID(String userEmilID) {
		this.userEmilID = userEmilID;
	}
	public String getEmailsubject() {
		return Emailsubject;
	}
	public void setEmailsubject(String emailsubject) {
		Emailsubject = emailsubject;
	}
	public Date getCretedDate() {
		return cretedDate;
	}
	public void setCretedDate(Date cretedDate) {
		this.cretedDate = cretedDate;
	}
    
    

}
