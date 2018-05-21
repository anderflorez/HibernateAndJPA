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
		
		Student myStudent = new Student("Alicia Coutts", "5-COU-2009");
		Tutor newTutor = new Tutor("DEF456", "Michael Jung", 939383);
		
		session.save(myStudent);
		session.save(newTutor);
		
		myStudent.allocateSupervisor(newTutor);
		
		System.out.println(myStudent.getSupervisorName());

//		Tutor newTutor = new Tutor("ABC844", "Adrian Nathan", 3876383);
//		
//		Student student1 = new Student("Rebecca Soni", "1-SON-2012");
//		Student student2 = new Student("Zou Kai", "2-KAI-2009");
//		Student student3 = new Student("Chris Hoy", "3-HOY-1997");
//		
//		session.save(student1);
//		session.save(student2);
//		session.save(student3);
//		session.save(newTutor);
//		
//		student1.allocateSupervisor(newTutor);
//		student2.allocateSupervisor(newTutor);
//		student3.allocateSupervisor(newTutor);
//		
//		System.out.println(student1.getSupervisor());
		
//		Tutor myTutor = (Tutor) session.get(Tutor.class, 1);
//		Set<Student> students = myTutor.getSupervisionGroup();
//		for (Student next : students) {
//			System.out.println(next);
//		}
//		
//		Student myStudent = (Student) session.get(Student.class, 2);
//		Tutor myStudentTutor = myStudent.getSupervisor();
//		System.out.println(myStudentTutor);
		
		
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
