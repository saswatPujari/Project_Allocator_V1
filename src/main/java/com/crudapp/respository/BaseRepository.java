package com.crudapp.respository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseRepository {
	
	private EntityManagerFactory emf = null;
    private EntityManager entityManager = null;
    
    public BaseRepository() {
    	this.emf = Persistence.createEntityManagerFactory("ProjectAllocatorPU"); // Create entity manager factory
    	this.entityManager = emf.createEntityManager(); // Create entity manager;
    }
    
    public EntityManager getEntityManager() {
    	return entityManager;
    }
    
    public EntityManagerFactory getEntityManagerFactory() {
    	return emf;
    }

}
