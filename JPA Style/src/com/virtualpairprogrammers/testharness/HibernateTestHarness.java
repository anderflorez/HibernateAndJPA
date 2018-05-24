package com.virtualpairprogrammers.testharness;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.virtualpairprogrammers.domain.Address;
import com.virtualpairprogrammers.domain.Person;
import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.domain.Subject;
import com.virtualpairprogrammers.domain.Tutor;

public class HibernateTestHarness 
{
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");

	public static void main(String[] args)
	{		
//		setUpData();
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
		
		// let's do some queries!
		
		//Using wildcards in the restriction with the like keyword
//		TypedQuery<Student> q = em.createQuery("from Student as student where lower(student.name) like '%k%'", Student.class);
		
		
		//DON'T EVER CONCATENATE VARIABLES INTO THE HQL
		//using variables in parameters avoid possible SQL injection
//		String requiredName = "marco fortes";
//		TypedQuery<Student> q = em.createQuery("from Student as student where lower(student.name) = :name", Student.class);
//		q.setParameter("name", requiredName);
		
		
		//Navigating across relationships
//		Tutor tutor = em.find(Tutor.class, 1);
//		//No need to specify a foreign key or id or anything, hibernate will do that automatically
//		TypedQuery<Student> q = em.createQuery("from Student as student where student.supervisor = :tutor", Student.class);
//		q.setParameter("tutor", tutor);
		
		
//		TypedQuery<Student> q = em.createQuery("from Student student where student.supervisor.name = 'David Banks'", Student.class);
		
//		TypedQuery<Student> q = em.createQuery("from Student student where student.address.city = 'Georgia'", Student.class);

//		TypedQuery<Tutor> q = em.createQuery("from Tutor tutor where tutor.supervisionGroup is empty", Tutor.class);
		
//		TypedQuery<Tutor> q = em.createQuery("from Tutor tutor where tutor.supervisionGroup is not empty", Tutor.class);
		
		
		//Query with member of
//		Subject history = em.find(Subject.class, 3);
//		//who teaches history? (without having a bi-directional relationship)
//		TypedQuery<Tutor> q = em.createQuery("from Tutor tutor where :subject member of tutor.subjectsQualifiedToTeach", Tutor.class);
//		q.setParameter("subject", history);
		
//		Subject math = em.find(Subject.class, 1);
//		//who teaches history? (without having a bi-directional relationship)
//		TypedQuery<Tutor> q = em.createQuery("from Tutor tutor where :math member of tutor.subjectsQualifiedToTeach", Tutor.class);
//		q.setParameter("math", math);
		
//		Subject science = em.find(Subject.class, 2);
//		TypedQuery<Student> q = em.createQuery("from Student student where :subject member of student.supervisor.subjectsQualifiedToTeach", Student.class);
//		q.setParameter("subject", science);
		
		
		
//		TypedQuery<Object[]> q = em.createQuery("from Tutor tutor join tutor.supervisionGroup as student where student.address.city = 'Georgia' ", Object[].class);
//		List<Object[]> results = q.getResultList();
//		for (Object[] next : results) {
//			System.out.println(next[0] + "------------ " + next[1]);
//		}
		
		
		
//		String city = "Georgia";
		
//		TypedQuery<Tutor> q = em.createQuery("select tutor from Tutor tutor join tutor.supervisionGroup as student where student.address.city = :city ", Tutor.class);
//		q.setParameter("city", city);
		
//		TypedQuery<Tutor> q = em.createQuery("select distinct tutor from Tutor tutor join tutor.supervisionGroup as student where student.address.city = :city ", Tutor.class);
//		q.setParameter("city", city);
		
//		TypedQuery<Tutor> q = em.createQuery("select distinct student.supervisor from Student student where student.address.city = :city ", Tutor.class);
//		q.setParameter("city", city);
		
//		List<Tutor> results = em.createQuery
//				("select distinct student.supervisor from Student student where student.address.city = :city ", Tutor.class)
//				.setParameter("city", city)
//				.getResultList();
//		for (Tutor next : results)
//		{
//			System.out.println(next);
//		}
		
		
		//Query Files
//		List<Student> results = em.createNamedQuery("searchByName", Student.class).setParameter("name", "Marco Fortes").getResultList();
//		for (Student next : results)
//		{
//			System.out.println(next);
//		}
		
		
		//Report Query
//		List<String> results = em.createQuery("select student.name from Student student", String.class).getResultList();
//		for (String next : results)
//		{
//			System.out.println(next);
//		}
		
		//Report Query with multiple fields
//		List<Object[]> results = em.createQuery("select student.name, student.supervisor.name from Student student", Object[].class).getResultList();
//		for (Object[] next : results)
//		{
//			System.out.println("Name: " + next[0] + ", thaught by: " + next[1]);
//		}
		
		
		//Counting records
//		long numberOfStudents = em.createQuery("select count (student) from Student student", Long.class).getSingleResult();
//		System.out.println(numberOfStudents);
//				
//		double averageSemesterLength = em.createQuery
//				("select avg(subject.numbnerOfSemesters) from Subject subject", Double.class)
//				.getSingleResult();
//		System.out.println(averageSemesterLength);
		
		
		//Updating multiple records
		//Working with objects is inefficient
//		List<Tutor> allTutors = em.createQuery("from Tutor", Tutor.class).getResultList();
//		for (Tutor next : allTutors)
//		{
//			next.doubleSalary();
//		}
		
		//The better way is to use HQL update/delete
//		int tutorsAffected = em.createQuery("update Tutor as tutor set tutor.salary = tutor.salary * 2").executeUpdate();
//		System.out.println("Salary increased for " + tutorsAffected + " tutors");
		
		
		//Native SQL
//		List<Object[]> results = em.createNativeQuery("select s.name, s.enrollmentid from student s").getResultList();
//		for (Object[] next : results)
//		{
//			System.out.println(next[0] + "; " + next[1]);
//		}
		
		//Auto instantiate objects if all data needed to create the object is retrieved from the database
//		List<Student> results = em.createNativeQuery("select * from student s", Student.class).getResultList();
//		for (Student next : results)
//		{
//			System.out.println(next);
//		}
		
		
		
		
//		List<Student> allStudents = q.getResultList();
//		for (Student next : allStudents)
//		{
//			System.out.println(next);
//		}
		
//		List<Tutor> allTutors = q.getResultList();
//		for (Tutor next : allTutors)
//		{
//			System.out.println(next);
//		}
		
		
		//Classic Criteria API
		
//		Session session = (Session) em.getDelegate();
		
//		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.like("name", "%Marco%"));
		
//		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.eq("name", "Kath Grainer"));
		
//		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.ilike("name", "%fortes%"));
		
		//Walking the object graph many to one
//		Criteria criteria = session.createCriteria(Student.class);
//		criteria.createCriteria("supervisor").add(Restrictions.eq("name", "David Banks"));
		
//		Criteria criteria = session.createCriteria(Tutor.class);
//		criteria.add(Restrictions.sizeEq("supervisionGroup", 0));
		
		//Joins
		// Get a list of all tutors who have a student that live in Georgia
//		Criteria criteria = session.createCriteria(Tutor.class);
//		criteria.createAlias("supervisionGroup", "student");
//		criteria.add(Restrictions.eq("student.address.city", "Georgia"));
//		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
//		List<Tutor> results = criteria.list();
//		for (Tutor next : results)
//		{
//			System.out.println(next);
//		}
		
		
		
		//JPA Criteria API
		
		// the "from" clause
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//		Root<Student> root = criteria.from(Student.class);
//		Query q = em.createQuery(criteria);
		
		// Adding a "where" clause
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//		Root<Student> root = criteria.from(Student.class);
//		criteria.where(builder.equal(root.get("name"), "Marco Fortes"));
//		TypedQuery<Student> q = em.createQuery(criteria);
		
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//		Root<Student> root = criteria.from(Student.class);
//		criteria.where(builder.and(builder.equal(root.get("name"), "Sandra Perkins"), builder.equal(root.get("enrollmentID"), "3-PER-2009")));
//		TypedQuery<Student> q = em.createQuery(criteria);
		
		//Walking the object Graph
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//		Root<Student> root = criteria.from(Student.class);
//		Path<Tutor> tutor = root.get("supervisor");
//		criteria.where(builder.equal(tutor.get("name"), "David Banks"));
//		TypedQuery<Student> q = em.createQuery(criteria);
		
		//Using the like method
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//		Root<Student> root = criteria.from(Student.class);
//		criteria.where(builder.like(root.get("name"), "%k%"));
//		TypedQuery<Student> q = em.createQuery(criteria);
		
		
		// Using Joins
		// Get a list of all tutors who have a student that live in Georgia
//		CriteriaBuilder builder = em.getCriteriaBuilder();
//		CriteriaQuery<Tutor> criteria = builder.createQuery(Tutor.class).distinct(true);
//		Root<Tutor> root = criteria.from(Tutor.class);
//		// in this case we need a join from tutor to students
//		Join<Tutor, Student> students = root.join("supervisionGroup");
//		Path<Address> address = students.get("address");
//		Path<String> city = address.get("city");
//		criteria.where(builder.equal(city, "Georgia"));
//		TypedQuery<Tutor> q = em.createQuery(criteria);
		
		
		
//		List<Student> results = q.getResultList();
//		for (Student next : results)
//		{
//			System.out.println(next);
//		}
		
//		List<Tutor> allTutors = q.getResultList();
//		for (Tutor next : allTutors)
//		{
//			System.out.println(next);
//		}

		
//		tx.commit();
//		em.close();
		
		
		//Inheritance
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Student newStudent = new Student("Bill Jones", "1-JON-2011", "4 the Terrace", "Chicago", "90393");
		Tutor newTutor = new Tutor("99499", "Martha Revees", 90000);
		
		em.persist(newStudent);
		em.persist(newTutor);
		
		List<Person> allPeople = em.createQuery("from Person", Person.class).getResultList();
		for (Person next : allPeople)
		{
			next.calculateReport();
		}
		
		tx.commit();
		em.close();

	}
	
	public static void setUpData()
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Some subjects
		Subject mathematics = new Subject("Mathematics", 2);
		Subject science = new Subject("Science", 2);
		Subject history = new Subject("History", 3);
		em.persist(mathematics);
		em.persist(science);
		em.persist(history);

		// This tutor will be very busy, with lots of students
		Tutor t1 = new Tutor("ABC123", "David Banks", 2939393);
		t1.addSubjectToQualifications(mathematics);
		t1.addSubjectToQualifications(science);
		
		// This tutor is new and has no students
		// But he will be able to teach science and mathematics
		Tutor t2 = new Tutor("DEF456", "Alan Bridges", 0);
		t2.addSubjectToQualifications(mathematics);
		t2.addSubjectToQualifications(science);
		
		// This tutor is the only tutor who can teach History
		Tutor t3 = new Tutor("GHI678", "Linda Histroia", 0);
		t3.addSubjectToQualifications(history);
		t3.addSubjectToQualifications(science);
		
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);

		// this only works because we are cascading from tutor to student
		t1.createStudentAndAddToSupervisionGroup("Marco Fortes", "1-FOR-2010", "1 The Street", "Georgia", "484848");
		t1.createStudentAndAddToSupervisionGroup("Kath Grainer", "2-GRA-2009", "2 Kaths Street", "Georgia", "939393");
		t3.createStudentAndAddToSupervisionGroup("Sandra Perkins", "3-PER-2009", "4 The Avenue", "Georgia", "939393");
		
		tx.commit();
		em.close();
	}

	
}