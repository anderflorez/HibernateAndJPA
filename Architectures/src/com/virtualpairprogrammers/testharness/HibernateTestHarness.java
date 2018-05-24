package com.virtualpairprogrammers.testharness;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateTestHarness 
{
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");

	public static void main(String[] args)
	{		
		
	}
	
}