package com.sprint1db.service;

import java.util.List;

import DAO.ApplicantDAO;
import DAO.ApplicantDAOImpl;
import com.sprint1db.entities.Applicant;
import com.sprint1db.exception.EntityNotFoundException;
//sumit

//unit testing 
//should he be able to test the service layer in isolation of db layer
//when we say unit testing 
//each and every developer
//should be able to test their codes

public class ApplicantServiceImpl  implements ApplicantService{
	
	//service consumes dao layer 
	private ApplicantDAO dao = new ApplicantDAOImpl();
	

	@Override
	public Applicant addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		 dao.addApplicant(applicant);
		return applicant;
	}

	@Override
	public Applicant updateApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
	 applicant = dao.updateApplicant(applicant);
		return applicant;
		
	}

	@Override
	public Applicant deleteApplicant(long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return dao.deleteApplicant(id);
	}

	@Override
	public Applicant listApplicantById(long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return dao.listApplicantById(id);
	}

	@Override
	public List<Applicant> listAllApplicants() {
		// TODO Auto-generated method stub
		return dao.listAllApplicants();
	}

}