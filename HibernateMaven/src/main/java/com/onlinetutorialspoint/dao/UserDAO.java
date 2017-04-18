package com.onlinetutorialspoint.dao;

//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.hibernate.Transaction;

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
            System.out.println("session : "+session);
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
	
	public static UserCount  checkservice(String emailID){
		
		System.out.println("checkservice");
		Users users = new Users();
		UserCount userCount = new UserCount();
		  Session session = null;
	        Transaction transaction = null;
	        try {
	        	
	        	
	            session = HibernateConnector.getInstance().getSession();
	            System.out.println("session : "+session);
	            transaction = session.beginTransaction();
	            String sql = "SELECT * FROM USERS WHERE userID IN(SELECT userID FROM UserDetails where userEmilID = :userEmilID)";
	    		SQLQuery query = session.createSQLQuery(sql);
	    		query.addEntity(Users.class);
	    		query.setParameter("userEmilID", emailID);
	    		List usersList = query.list();
	    		List usercountlist = null;	
	            for (Iterator iterator = 
	            		usersList.iterator(); iterator.hasNext();){
	            	users = (Users) iterator.next(); 
	               System.out.print("First Name: " + users.getEmailsubject());
	               
	               String countsql = "SELECT * FROM userscount WHERE userID = :userID";
	               SQLQuery countQuery = session.createSQLQuery(countsql);
	               countQuery.addEntity(UserCount.class);
	               countQuery.setParameter("userID", users.getUserID());
		    		usercountlist = query.list();
	            }
	            
	            for (Iterator iterator = 
	            		usercountlist.iterator(); iterator.hasNext();){
	            	userCount = (UserCount) iterator.next(); 
	               
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
	        try {
	            session = HibernateConnector.getInstance().getSession();
	            session.saveOrUpdate(userCount);
	            session.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
}
