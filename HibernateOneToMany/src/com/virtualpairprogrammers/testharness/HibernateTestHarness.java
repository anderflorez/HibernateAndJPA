package com.virtualpairprogrammers.testharness;

import java.util.Set;

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
		
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		Tutor newTutor = new Tutor("ABC844", "Adrian Nathan", 3876383);
		
		Student student1 = new Student("Rebecca Soni");
		Student student2 = new Student("Zou Kai");
		Student student3 = new Student("Chris Hoy");
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(newTutor);

		newTutor.addStudentToSupervisionGroup(student1);
		newTutor.addStudentToSupervisionGroup(student2);
		newTutor.addStudentToSupervisionGroup(student3);
		
//		Set<Student> students = newTutor.getSupervisionGroup();
//		for (Student next : students) {
//			System.out.println(next);
//		}
		
		Tutor myTutor = (Tutor) session.get(Tutor.class, 1);
		Set<Student> students = myTutor.getSupervisionGroup();
		for (Student next : students) {
			System.out.println(next);
		}
		
		Student student4 = new Student("Cullen Jones");
		session.save(student4);
		myTutor.addStudentToSupervisionGroup(student4);
		
		
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
