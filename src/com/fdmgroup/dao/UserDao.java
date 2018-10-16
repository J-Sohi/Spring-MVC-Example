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

	public boolean create(User user){
		System.out.println(user);
		em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public boolean delete(int id){
		em = con.getEntityManager();
		User managedUser = em.find(User.class, id);
		em.getTransaction().begin();
		em.remove(managedUser);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public boolean softDelete(int id){
		em = con.getEntityManager();
		User managedUser = em.find(User.class, id);
		em.getTransaction().begin();
		//managedUser.setActive(false);
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	public List<User> findAll(){
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findAll", User.class);	
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	public List<User> findByFirstName(String fname) {
		em = con.getEntityManager();
		System.out.println("FNAME========" + fname );
		TypedQuery<User> query = em.createNamedQuery("user.findByFirstname", User.class);
		query.setParameter("fname", fname + "%");
		List<User> users = query.getResultList();
		em.close();
		
		return users;
	}
	
	public User findById(int id){
		em = con.getEntityManager();
		User user = em.find(User.class, id);
		em.close();
		return user;
	}

	public User findByUsername(String username) {
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByUsername", User.class);
		query.setParameter("uname", username);
		User user = query.getSingleResult();
		List<User> users = query.getResultList();
		em.close();
		
		if (users != null && users.size() == 1){
			return users.get(0);
		}
		return null;
	}
	
	public List<User> findByType(Class type){
		em = con.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("user.findByType", User.class);
		query.setParameter("type", type);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}
	
}
