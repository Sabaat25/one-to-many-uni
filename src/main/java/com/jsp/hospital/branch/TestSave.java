package com.jsp.hospital.branch;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave { 
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vishu");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital=new Hospital();
		hospital.setName("Apollo Hospital"); 
		hospital.setLocation("Mumbai"); 
		hospital.setRating(4.7); 

		Branch branch1=new Branch(); 
		branch1.setName("Apollo Hospital Mumbai" ); 
		branch1.setAddress("CBD Belapur"); 
		branch1.setNumOfDoctors(212); 
		branch1.setPhone_no(109087675); 
		
		Branch branch2=new Branch(); 
		branch2.setName("Apollo Spectra"); 
		branch2.setAddress("Mumbai"); 
		branch2.setNumOfDoctors(150); 
		branch2.setPhone_no(879657893); 
		
		Branch branch3=new Branch(); 
		branch3.setName("Apollo Clinic"); 
		branch3.setAddress("Colaba"); 
		branch3.setNumOfDoctors(10); 
		branch3.setPhone_no(987482684);
	    
	    
	    ArrayList<Branch> branch=new ArrayList<Branch>();
	    branch.add(branch1); 
	    branch.add(branch2); 
	    branch.add(branch3);
	            
	     
	    hospital.setBranch(branch);
	     
	     entityTransaction.begin();
	     entityManager.persist(hospital);
	     entityManager.persist(branch1);
	     entityManager.persist(branch2);
	     entityManager.persist(branch3);
	     entityTransaction.commit();
	     
	    
	}

}
