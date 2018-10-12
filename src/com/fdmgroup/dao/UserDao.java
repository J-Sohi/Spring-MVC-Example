package com.fdmgroup.dao;

import java.util.List;



import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.User;

public class UserDao {
	
	@Autowired
	private DbConnection con;
	private EntityManager em;
	
	public UserDao(){
		super();
		//con = DbConnection.getInstance();
	}

	public List<User> findAll(){
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);	
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	public User findByUsername(String username) {
		System.out.println("username is ....." + username);
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("uname", username);
		User user = query.getSingleResult();
		em.close();
		
		/*if (user != null && user.size() == 1){
			return user;
		}*/
		return user;
	}
	
}
