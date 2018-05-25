package com.virtualpairprogrammers.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.virtualpairprogrammers.domain.Tutor;

/*
 * This is not production standard code
 * It should not be used for any real project
 */

public class TutorManagement
{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
	
	public Tutor createNewTutor(String staffId, String name, int salary)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Tutor newTutor = new Tutor(staffId, name, salary);
		
		em.persist(newTutor);
		
		//we can use the merge method to persist an object but it shouldn't be used 
		//for that purpose if the id is not auto-generated 
		//newTutor = em.merge(newTutor);
		
		// commit will release any database connection
		tx.commit();
		
		//the close will detach the tutor object
		em.close();
		return newTutor;
	}
	
	public Tutor findTutorById(int id) 
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Tutor tutor = em.find(Tutor.class, id);
		
		tx.commit();
		em.close();
		
		return tutor;
	}
	
	public Tutor updateTutor(Tutor tutorToUpdate)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// make the object be dirty checkable again by re-attaching it to the entity manager
		// the reference to the object should be reassigned as the merge method will return a new object
		tutorToUpdate = em.merge(tutorToUpdate);
		
		tx.commit();
		em.close();
		
		return tutorToUpdate;
	}

}
