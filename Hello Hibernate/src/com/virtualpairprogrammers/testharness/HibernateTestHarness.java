package com.virtualpairprogrammers.testharness;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.virtualpairprogrammers.domain.Student;

public class HibernateTestHarness {
	
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) 
	{
		Student testStudent = new Student("Jessica Ennis", "Toni Minichiello");
		System.out.println(testStudent + " has a greade point average of " + testStudent.calculateGradePointAverage());
		
		//Save the student to the database
		
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		
		session.save(testStudent);
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
