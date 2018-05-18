package com.virtualpairprogrammers.testharness;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.domain.Tutor;

public class HibernateTestHarness {
	
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) 
	{
		
		//Save a student to the database
//		Student myStudent = new Student("Ricky Berens", "Eddie Reese");
//		SessionFactory sf = getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(myStudent);
//		
//		System.out.println(myStudent);
//		
//		tx.commit();
//		session.close();
		
		
		//Retrieve a student from the database based on the id
//		SessionFactory sf = getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//
//		Student myStudent = (Student) session.get(Student.class, 1);
//		session.delete(myStudent);
//		System.out.println(myStudent);
//		
//		tx.commit();
//		session.close();		

		//Delete a student from the database
//		SessionFactory sf = getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//
//		Student myStudent = (Student) session.get(Student.class, 2);
//		session.delete(myStudent);
//		System.out.println(myStudent);
//		
//		tx.commit();
//		session.close();
		
		
		//Update a student in the database
//		SessionFactory sf = getSessionFactory();
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		Student myStudent = (Student) session.get(Student.class, 3);
//		myStudent.setTutorName("Dave Salo");
//		
//		System.out.println(myStudent);
//		
//		tx.commit();
//		session.close();
		

/*
		//Create a relationship in the database
		
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//Create new student and tutor
		Student myStudent = new Student("Alicia Cutts");
		Tutor newTutor = new Tutor("DEF456", "Michael Jung", 939383);
		
		session.save(myStudent);
		session.save(newTutor);
		
		//Make the student be supervised by that tutor
		myStudent.allocateSupervisor(newTutor);
		
		//print out the supervisor
		System.out.println(myStudent.getSupervisorName());
		
		tx.commit();
		session.close();
*/
		
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Student foundStudent = (Student) session.get(Student.class, 1);
		System.out.println(foundStudent);

		foundStudent.allocateSupervisor(null);
		
		Tutor myTutor = (Tutor) session.get(Tutor.class, 2);
		myTutor.
		
		tx.commit();
		session.close();
		
	}
	
	public static SessionFactory getSessionFactory() 
	{
		if (sessionFactory == null) 
		{
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).buildServiceRegistry();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	
	

}
