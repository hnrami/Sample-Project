package com.onlinetutorialspoint.camel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.onlinetutorialspoint.dao.UserDAO;
import com.onlinetutorialspoint.pojo.UserCount;
import com.onlinetutorialspoint.pojo.UserDetails;
import com.onlinetutorialspoint.pojo.Users;

public class Util {
	
	
	public static Date CurrentDate(){
	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    return timestamp;
	}
	
	
	public static int count(String word, String line){
	    Pattern pattern = Pattern.compile(word);
	    Matcher matcher = pattern.matcher(line);
	    int counter = 0;
	    while (matcher.find())
	        counter++;
	    return counter;
	}
	
	
	
	public static Boolean AddUsers(String from,String subject,String body){
		System.out.println(CurrentDate());
		int count = count("@gmail.com",body);
		System.out.println("count"+count);
		if(count >= 1){
			System.out.println("if");
			UserDAO userDAO = new UserDAO();
			UserCount userCount= UserDAO.checkservice(from);
			Users users = new Users();
			users.setUserID(userCount.getUser().getUserID());
			users.setUserName(from);
			users.setUserEmilID(from);
			users.setCretedDate(Util.CurrentDate());
			users.setEmailsubject(subject);
			
			
			UserDetails userDetails = new UserDetails();
			
			if(body.length() >999){
				body = body.substring(0, 999);
			}
			userDetails.setBody(body);
			userDetails.setCretedDate(Util.CurrentDate());
			userDetails.setUserEmilID(from);
			userDetails.setUsers(users);
			
			userDetails = userDAO.addUserDetails(userDetails);
			
			userCount.setCount(count);
			userDAO.updateUserCount(userCount);
		}
		else{
		
		
			UserDAO userDAO = new UserDAO();
			Users users = new Users();
			users.setUserName(from);
			users.setUserEmilID(from);
			users.setCretedDate(Util.CurrentDate());
			users.setEmailsubject(subject);
			users = userDAO.addUsers(users);
			
			System.out.println(users.getUserEmilID());
			
			
			UserDetails userDetails = new UserDetails();
			
			if(body.length() >999){
				body = body.substring(0, 999);
			}
			userDetails.setBody(body);
			userDetails.setCretedDate(users.getCretedDate());
			userDetails.setUserEmilID(users.getUserEmilID());
			userDetails.setUsers(users);
			
			userDetails = userDAO.addUserDetails(userDetails);
				
			UserCount userCount = new UserCount();
			
			userCount.setCount(count);
			
			userCount.setUser(users);
			
			userDAO.addUsercount(userCount);

		}
		
		return true;		
		
	}
    

}
