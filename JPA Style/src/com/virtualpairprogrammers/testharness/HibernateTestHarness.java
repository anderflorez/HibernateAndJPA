package com.virtualpairprogrammers.testharness;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;

import com.virtualpairprogrammers.domain.Address;
import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.domain.Tutor;

public class HibernateTestHarness {
	
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) 
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
//		Tutor t1 = new Tutor("ABC123", "David Banks", 2939393);
//		em.persist(t1);
		
//		t1.createStudentAndAddToSupervisionGroup("Marco Fortes", "1-FOR-2010", "1 The Street", "Anytown", "484848");
//		t1.createStudentAndAddToSupervisionGroup("Kath Grainer", "2-GRA-2009", "2 Kaths Street", "Georgia", "939393");
		
//		Student student = new Student("Dimitri Peters", "1-PET-2011");
//		em.persist(student);
		
		Student studentFromDatabase = em.find(Student.class, 1);
		System.out.println(studentFromDatabase);
		
		if (studentFromDatabase.getAddress() == null) {
			studentFromDatabase.setAddress(new Address("1 Pall Mall", "London", "W1A 1WW"));
		}
		
		tx.commit();
		em.close();
	}
	
}
