package com.virtualpairprogrammers.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique=true, nullable=false)
	private String subjectName;
	
	private int numbnerOfSemesters;
	
	@ManyToMany
	private Set<Tutor> qualifiedTutors;
	
	// Hibernate required a no-argument constructor
	public Subject() {}

	public Subject(String name, int numberOfSemesters)
	{
		super();
		this.subjectName = name;
		this.numbnerOfSemesters = numberOfSemesters;
		this.qualifiedTutors = new HashSet<>();
	}
	
	public String getName()
	{
		return subjectName;
	}

	public void setName(String name)
	{
		this.subjectName = name;
	}

	public void addTutorToSubject(Tutor tutor)
	{
		this.qualifiedTutors.add(tutor);
		tutor.getSubjects().add(this);
	}
	
	public Set<Tutor> getQualifiedTutors()
	{
		return this.qualifiedTutors;
	}
	
	public String toString() 
	{
		return this.subjectName + " lasts for " + this.numbnerOfSemesters + " semesters";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
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
		Subject other = (Subject) obj;
		if (subjectName == null)
		{
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	
	
}
