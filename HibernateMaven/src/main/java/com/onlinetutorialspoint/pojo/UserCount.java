package com.onlinetutorialspoint.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserCount {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userCountID;
	@OneToOne
	@JoinColumn(name="usersID")
	private Users user;
	
	private int count;

	public int getUserCountID() {
		return userCountID;
	}

	public void setUserCountID(int userCountID) {
		this.userCountID = userCountID;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
