package com.virtualpairprogrammers.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Represents a Student enrolled in the college management
 * system (CMS)
 */

@Entity
public class Student
{
	// We're using field access, so the annotations are before the fields instead of the get methods
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String enrollmentID;
    private String name;
    
    @ManyToOne
    @JoinColumn(name="TUTOR_FK")
    private Tutor supervisor;
    
    /*
     * Empty constructor required by Hibernate
     */
    public Student ()
    {

    }
    
    /**
     * Initialises a student with a particular tutor
     */
    public Student(String name, Tutor supervisor)
    {
    	this.name = name;
    	this.supervisor = supervisor;
    }
    
    /**
     * Initialises a student with no pre set tutor
     */
    public Student(String name)
    {
    	this.name = name;
    	this.supervisor = null;
    }
    
    public double calculateGradePointAverage()
    {
    	// some complex business logic!
    	// we won't need this method on the course, BUT it is import
    	// to remember that classes aren't just get/set pairs - we expect
    	// business logic in here as well.
    	return 0;
    }
    
    public String toString() 
    {
    	return this.name;
    }

    public int getId() 
    {
    	return this.id;
    }

	public void allocateSupervisor(Tutor newSupervisor)
	{
		this.supervisor = newSupervisor;		
	}

	public String getSupervisorName()
	{
		return this.supervisor.getName();
	}
	
	public Tutor getSupervisor()
	{
		return this.supervisor;
	}
	
	

}
