package com.onlinetutorialspoint.dao;

//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutorialspoint.config.HibernateConnector;
import com.onlinetutorialspoint.pojo.UserCount;
import com.onlinetutorialspoint.pojo.UserDetails;
import com.onlinetutorialspoint.pojo.Users;

public class UserDAO {

	
	public Users addUsers(Users users) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(users);
            transaction.commit();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
	
	public UserDetails addUserDetails(UserDetails userDetails) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("Date Insert in UserDeatils");
            transaction = session.beginTransaction();
            session.save(userDetails);
            transaction.commit();
            return userDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
	
	public UserCount addUsercount(UserCount userCount) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(userCount);
            transaction.commit();
            return userCount;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
	
	public static UserCount checkCount(String emailID){
		
		System.out.println("checkservice");
		Users users = new Users();
		UserDetails userDetails = new UserDetails();
		UserCount userCount = new UserCount();
		  Session session = null;
	        Transaction transaction = null;
	        try {
	        	
	        	
	            session = HibernateConnector.getInstance().getSession();
	            System.out.println("session : "+session);
	            transaction = session.beginTransaction();																		   
	            String sql = "SELECT * FROM USERCOUNT as userc WHERE userc.usersID IN (SELECT users.userID FROM USERS as users where users.userID IN (SELECT userd.usersID FROM UserDetails as userd where userd.userEmilID = :userEmilID)) AND userc.count < 7 ORDER BY userCountID DESC LIMIT 1 ";
	    		SQLQuery query = session.createSQLQuery(sql);
	    		query.addEntity(UserCount.class);
	    		query.setParameter("userEmilID", emailID);
	    		
	    		List userscountList = query.list();
	    		if(userscountList.size() >= 1 ){
	    			
	    			 for (Iterator iterator =  userscountList.iterator(); iterator.hasNext();){
	 	            	userCount = (UserCount) iterator.next(); 
	 	            	System.out.println("Count:---"+userCount.getUser().getUserID());;
	 	            }
	    		}else{
	    			 transaction.commit();
	    			return null;
	    		}
	           
	            transaction.commit();
	            return userCount;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } 
	        
	    	
	}
	
	 public void updateUserCount(UserCount userCount) {
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            System.out.println("updateUserCount"+userCount.getCount());
	            transaction = session.beginTransaction();	
	            String sql = "UPDATE USERCOUNT as userC SET userC.count=:count where userC.userCountID=:userCountID";
	            SQLQuery query = session.createSQLQuery(sql);
	    		query.addEntity(UserCount.class);
	    		query.setParameter("count", userCount.getCount());
	    		query.setParameter("userCountID", userCount.getUserCountID());
	    		 query.executeUpdate();
	    		transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
}
