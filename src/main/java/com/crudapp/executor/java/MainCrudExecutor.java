package com.crudapp.executor.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.crudapp.entity.Activity;
import com.crudapp.entity.Address;
import com.crudapp.entity.Assignment;
import com.crudapp.entity.Device;
import com.crudapp.entity.Project;
import com.crudapp.entity.User;
import com.crudapp.respository.ActivityRepository;
import com.crudapp.respository.AddressRepository;
import com.crudapp.respository.AssignmentRepository;
import com.crudapp.respository.BaseRepository;
import com.crudapp.respository.DeviceRepository;
import com.crudapp.respository.ProjectRepository;
import com.crudapp.respository.UserRepository;

public class MainCrudExecutor {
	
	public static void main(String[] args) {
		BaseRepository baseRepo = new BaseRepository();
        try {
            viewTableDetails(baseRepo.getEntityManager()); // View details of tables
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close entity manager and entity manager factory
        	close(baseRepo.getEntityManager(),baseRepo.getEntityManagerFactory());
        }

	}
	
	private static void viewTableDetails(EntityManager em) {
        try {
            // Start transaction
            em.getTransaction().begin();
            System.out.println("Details of Address table:");
            
            // View details of Address table
            System.out.println("Details of Activity table:");
            System.out.println("******** PRINTING ADDRESS : BEGIN ********");
            for (Address address : new AddressRepository().findAll()) {
            	System.out.println(address.toString());
            }
            System.out.println("******** PRINTING ADDRESS : END ********");
            
            // View details of Device table
            System.out.println("Details of Device table:");
            System.out.println("******** PRINTING DEVICE : BEGIN ********");
            for (Device device : new DeviceRepository().findAll()) {
                System.out.println(device.toString());
            }
            System.out.println("******** PRINTING DEVICE : END ********");
            
            // View details of USER table
            System.out.println("Details of USER table:");
            System.out.println("******** PRINTING USER : BEGIN ********");
            for (User user : new UserRepository().findAll()) {
                System.out.println(user.toString());
            }
            System.out.println("******** PRINTING USER : END ********");
            
            
            // View details of Project table
            System.out.println("Details of Project table:");
            System.out.println("******** PRINTING PROJECT : BEGIN ********");
            for (Project project : new ProjectRepository().findAll()) {
                System.out.println(project.toString());
            }
            System.out.println("******** PRINTING PROEJCT : END ********");
            
            // View details of Activity table
            System.out.println("Details of USER table:");
            System.out.println("******** PRINTING ACTIVITY : BEGIN ********");
            for (Activity activity : new ActivityRepository().findAll()) {
                System.out.println(activity.toString());
            }
            System.out.println("******** PRINTING ACTIVITY : END ********");
            
            // View details of Assignment table
            System.out.println("Details of Assignment table:");
            System.out.println("******** PRINTING ASSIGNMENTS : BEGIN ********");
            for (Assignment asg : new AssignmentRepository().findAll()) {
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
