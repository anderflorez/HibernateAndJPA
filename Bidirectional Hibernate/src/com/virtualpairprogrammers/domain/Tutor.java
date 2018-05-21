package com.virtualpairprogrammers.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tutor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	private String staffId;
	private String name;
	private int salary;
	
	@OneToMany(mappedBy="supervisor")
	private Set<Student> supervisionGroup;
	
	// Required by Hibernate
	public Tutor()
	{}

	//Business constructor
	public Tutor(String staffId, String name, int salary)
	{
		super();
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
		this.supervisionGroup = new HashSet<>();
	}
	
	public void addStudentToSupervisionGroup(Student studentToAdd)
	{
		this.supervisionGroup.add(studentToAdd);
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

	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		return "Tutor: " + this.name + " (" + this.staffId + ") ";
	}

}