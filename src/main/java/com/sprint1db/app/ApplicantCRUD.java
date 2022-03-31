package com.sprint1db.app;


import java.util.Scanner;

import com.sprint1db.entities.Applicant;
import com.sprint1db.exception.EntityNotFoundException;
import com.sprint1db.service.ApplicantService;
import com.sprint1db.service.ApplicantServiceImpl;


public class ApplicantCRUD {
private static ApplicantService service =  new ApplicantServiceImpl();

	public static void main(String[] args) {
		System.out.println("1.Add an applicant");
		System.out.println("2.update an applicant");
		System.out.println("3.delete an applicant");
		System.out.println("4.List an applicant");
		System.out.println("5.List all applicants");
		System.out.println("Enter choice");
		int choice = new Scanner(System.in).nextInt();
		
		switch (choice) {
		case 1: Applicant addApplicant = acceptDetails();
				addApplicant=service.addApplicant(addApplicant);
				System.out.println("added "+addApplicant);
				break;
		
		case 2 : Applicant updatedByUserApplicant = acceptDetails();
		          Applicant a =service.updateApplicant(updatedByUserApplicant);
		          System.out.println(a);
		          break;
		          
		case 3 : System.out.println("Enter applicant id ");
		int idd = new Scanner(System.in).nextInt();
		
		try {
			Applicant a2 = service.deleteApplicant(idd);
		} catch (EntityNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());;
		}
		break;
		case 4:
		System.out.println("Enter product id ");
		int id = new Scanner(System.in).nextInt();
		try {
			System.out.println(service.listApplicantById(id));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
		 System.out.println(e.getMessage());
		}
		break;
		case 5:System.out.println(service.listAllApplicants());
		break;
//	               
		default : 
			System.out.println("Invalid choice");
			System.exit(0);
	
		}       
}
	
//	private static Applicant acceptDetails() {
//		
//		Scanner scanner =new Scanner(System.in);
//		System.out.println("Enter id to be updated ");
//		int id =  scanner.nextInt();
//		
//	   Applicant retrievedData = null;
//	try {
//		retrievedData = service.listApplicantById(id);
//	} catch (EntityNotFoundException e) {
//		// TODO Auto-generated catch block
//		System.out.println(e.getMessage());
//	}
//	
//		System.out.println("Enter new phone Number");
//		String phnum =  scanner.next();
//		System.out.println("Enter new email ");
//        String em =  scanner.next();
//     retrievedData.setPhoneNumber(phnum); 
//     retrievedData.setEmailId(em);
//     return retrievedData;
//     
//	}
//	
	private static Applicant acceptDetails() {
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter id");
		long id =  scanner.nextLong();
		System.out.println("Enter name");
		String name = scanner.next();
		System.out.println("Enter phone no.");
		String phone =  scanner.next();
		System.out.println("Enter email");
        String emailId =  scanner.next();
        
        Applicant a= new Applicant(id,name,phone,emailId);
        return a;
			
		}

}