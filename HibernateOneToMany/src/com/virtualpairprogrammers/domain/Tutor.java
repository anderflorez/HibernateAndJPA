package com.virtualpairprogrammers.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Tutor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	private String staffId;
	private String name;
	private int salary;
	
	@OneToMany
	@OrderBy("name")
	@JoinColumn(name="TUTOR_FK")
	private List<Student> supervisionGroup;
	
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
		this.supervisionGroup = new ArrayList<>();
	}
	
	public void addStudentToSupervisionGroup(Student studentToAdd)
	{
		this.supervisionGroup.add(studentToAdd);
	}
	
	public List<Student> getSupervisionGroup() 
	{
		List<Student> unmodifiable = Collections.unmodifiableList(this.supervisionGroup);
		return unmodifiable;
	}

	public String getName()
	{
		return this.name;
	}

}
