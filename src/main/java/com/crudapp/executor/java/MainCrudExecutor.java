package com.crudapp.executor.java;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.crudapp.entity.Activity;
import com.crudapp.entity.Address;
import com.crudapp.entity.Assignment;
import com.crudapp.entity.Device;
import com.crudapp.entity.Project;
import com.crudapp.entity.User;

public class MainCrudExecutor {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("ProjectAllocatorPU"); // Create entity manager factory
            em = emf.createEntityManager(); // Create entity manager
            viewTableDetails(em); // View details of tables

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close entity manager and entity manager factory
        	close(em,emf);
        }

	}
	
	@SuppressWarnings("unchecked")
	private static void viewTableDetails(EntityManager em) {
        try {
            // Start transaction
            em.getTransaction().begin();
            System.out.println("Details of Address table:");
            
            // View details of Address table
            Query query = em.createQuery("SELECT a FROM Address a");
            List<Address> addresses = query.getResultList();
            System.out.println("******** PRINTING ADDRESS : BEGIN ********");
            for (Address address : addresses) {
            	System.out.println(address.toString());
            }
            System.out.println("******** PRINTING ADDRESS : END ********");
            
            // View details of Device table
            System.out.println("Details of Device table:");
            Query deviceQuery = em.createQuery("SELECT d FROM Device d");
            List<Device> devices = deviceQuery.getResultList();
            System.out.println("******** PRINTING DEVICE : BEGIN ********");
            for (Device device : devices) {
                System.out.println(device.toString());
            }
            System.out.println("******** PRINTING DEVICE : END ********");
            
            // View details of USER table
            System.out.println("Details of USER table:");
            Query userQuery = em.createQuery("SELECT u FROM User u");
            List<User> users = userQuery.getResultList();
            System.out.println("******** PRINTING USER : BEGIN ********");
            for (User user : users) {
                System.out.println(user.toString());
            }
            System.out.println("******** PRINTING USER : END ********");
            
            
            // View details of Project table
            System.out.println("Details of Project table:");
            Query projectQuery = em.createQuery("SELECT p FROM Project p");
            List<Project> projects = projectQuery.getResultList();
            System.out.println("******** PRINTING PROJECT : BEGIN ********");
            for (Project project : projects) {
                System.out.println(project.toString());
            }
            System.out.println("******** PRINTING PROEJCT : END ********");
            
            // View details of Activity table
            System.out.println("Details of USER table:");
            Query activityQuery = em.createQuery("SELECT act FROM Activity act");
            List<Activity> activities = activityQuery.getResultList();
            System.out.println("******** PRINTING ACTIVITY : BEGIN ********");
            for (Activity activity : activities) {
                System.out.println(activity.toString());
            }
            System.out.println("******** PRINTING ACTIVITY : END ********");
            
            // View details of Assignment table
            System.out.println("Details of Assignment table:");
            Query asgQuery = em.createQuery("SELECT asg FROM Assignment asg");
            List<Assignment> asgs = asgQuery.getResultList();
            System.out.println("******** PRINTING ASSIGNMENTS : BEGIN ********");
            for (Assignment asg : asgs) {
                System.out.println(asg.toString());
            }
            System.out.println("******** PRINTING ASSIGNMENTS : END ********");
            em.getTransaction().commit();
        } catch (Exception e) {
            // Rollback transaction if there's an exception
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
	
	private static void close(EntityManager em, EntityManagerFactory emf) {
		if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
	}

}
