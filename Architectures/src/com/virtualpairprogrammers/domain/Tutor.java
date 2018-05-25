package com.virtualpairprogrammers.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Tutor
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique=true, nullable=false)
	private String staffId;
	private int salary;
	private String name;
	
	@OneToMany(mappedBy="supervisor", cascade= { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Student> supervisionGroup;
	
	@ManyToMany(mappedBy="qualifiedTutors")
	private Set<Subject> subjectsQualifiedToTeach;
	
	@Version
	private int version;
	
	// Required by Hibernate
	public Tutor() {}

	//Business constructor
	public Tutor(String staffId, String name, int salary)
	{
		this.name = name;
		this.staffId = staffId;
		this.salary = salary;
		this.supervisionGroup = new HashSet<>();
		this.subjectsQualifiedToTeach = new HashSet<>();
	}
	
	public void doubleSalary() 
	{
		this.salary *= 2;
	}
	
	public void addStudentToSupervisionGroup(Student studentToAdd)
	{
		this.supervisionGroup.add(studentToAdd);
		studentToAdd.allocateSupervisor(this);
	}
	
	public void calculateReport()
	{
		System.out.println("report for tutor " + this.getName());
	}
	
	public Set<Student> getSupervisionGroup() 
	{
		Set<Student> unmodifiable = Collections.unmodifiableSet(this.supervisionGroup);
		return unmodifiable;
	}
	
	public Set<Student> getModifiableSupervisionGroup() 
	{
		return this.supervisionGroup;
	}
	
	public Set<Subject> getSubjects()
	{
		return this.subjectsQualifiedToTeach;
	}
	
	public void addSubjectToQualifications(Subject subject)
	{
		subject.getQualifiedTutors().add(this);
		this.subjectsQualifiedToTeach.add(subject);
	}

	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return "Tutor: " + this.getName() + " (" + this.staffId + ") ";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((staffId == null) ? 0 : staffId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		if (staffId == null)
		{
			if (other.staffId != null)
				return false;
		} else if (!staffId.equals(other.staffId))
			return false;
		return true;
	}

	public void createStudentAndAddToSupervisionGroup(String studentName, String enrollmentId, String street, String city, String zipOrPostcode)
	{
		Student student = new Student(studentName, enrollmentId, street, city, zipOrPostcode);
		this.addStudentToSupervisionGroup(student);
	}

	public void setName(String name)
	{
		this.name = name;
		
	}
	
	

}