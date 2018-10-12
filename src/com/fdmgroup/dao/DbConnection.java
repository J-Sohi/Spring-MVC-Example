package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
	private static String persistenceUnit;
	//private static DbConnection con = null;
	private EntityManagerFactory emf = null;
	
	private DbConnection(){
		init();
	}
	
	public static String getPersistenceUnit() {
		return persistenceUnit;
	}

	public static void setPersistenceUnit(String persistenceUnit) {
		DbConnection.persistenceUnit = persistenceUnit;
	}

	private void init(){
		if (emf ==  null || !emf.isOpen()){
			emf = Persistence.createEntityManagerFactory(persistenceUnit);
		}
	}
	
	/*public static DbConnection getInstance(){
		if (con == null){
			con = new DbConnection();
		}

		return con;
	}*/
	
	public EntityManager getEntityManager(){
		init();
		return emf.createEntityManager();
	}
	
	public void close(){
		if (emf != null && emf.isOpen()){
			emf.close();
		}
	}
}
