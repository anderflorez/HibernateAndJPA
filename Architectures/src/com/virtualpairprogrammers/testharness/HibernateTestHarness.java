package com.virtualpairprogrammers.testharness;

import java.util.Scanner;

import javax.persistence.OptimisticLockException;

import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.TutorManagement;

public class HibernateTestHarness 
{
	public static void main(String[] args)
	{		
		TutorManagement tutorManagement = new TutorManagement();
		
		Tutor newTutor = tutorManagement.findTutorById(1);
		
		// client will sit and wait ...
		newTutor.setName("Process 2 Name");
		
		System.out.println("Press enter to continue...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();

		try
		{
			// Check for stale object
			tutorManagement.updateTutor(newTutor);
		} catch (OptimisticLockException e)
		{
			System.out.println("Sorry, that tutor has been updated or deleted by another process");
		}
		
	}
	
}