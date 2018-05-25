package com.virtualpairprogrammers.testharness;

import java.util.Scanner;

import javax.persistence.OptimisticLockException;

import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.TutorManagement;

public class HibernateTestHarness 
{
	public static void main(String[] args)
	{	
		// Locking testing
//		TutorManagement tutorManagement = new TutorManagement();
//		
//		Tutor newTutor = tutorManagement.findTutorById(1);
//		
//		// client will sit and wait ...
//		newTutor.setName("Process 2 Name");
//		
//		System.out.println("Press enter to continue...");
//		Scanner sc = new Scanner(System.in);
//		sc.nextLine();
//		sc.close();
//
//		try
//		{
//			// Check for stale object
//			tutorManagement.updateTutor(newTutor);
//		} catch (OptimisticLockException e)
//		{
//			System.out.println("Sorry, that tutor has been updated or deleted by another process");
//		}
		
		// Performance
		TutorManagement tutorManagement = new TutorManagement();
		Tutor newTutor = tutorManagement.findTutorByIdWithSupervisionGroup(1);
		System.out.println("The name of the tutor " + newTutor.getName());
		System.out.println("The tutor has " + newTutor.getSupervisionGroup().size() + " students");
		
	}
	
}