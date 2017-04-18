package com.onlinetutorialspoint.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserDetails {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userDetailsID;
	@OneToOne
	@JoinColumn(name="usersID")
	private Users users;
    private String  userEmilID;
    @Lob
    private String  body;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date  cretedDate;
	public int getUserDetailsID() {
		return userDetailsID;
	}
	public void setUserDetailsID(int userDetailsID) {
		this.userDetailsID = userDetailsID;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getUserEmilID() {
		return userEmilID;
	}
	public void setUserEmilID(String userEmilID) {
		this.userEmilID = userEmilID;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCretedDate() {
		return cretedDate;
	}
	public void setCretedDate(Date cretedDate) {
		this.cretedDate = cretedDate;
	}
    
    
}
