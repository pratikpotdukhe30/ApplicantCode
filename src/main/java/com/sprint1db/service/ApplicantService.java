package com.sprint1db.service;


import java.util.List;

import com.sprint1db.entities.Applicant;
import com.sprint1db.exception.EntityNotFoundException;

public interface ApplicantService {

	Applicant addApplicant(Applicant applicant);
	Applicant updateApplicant(Applicant applicant);
	Applicant deleteApplicant(long id) throws EntityNotFoundException;
	Applicant listApplicantById(long id) throws EntityNotFoundException;
	List<Applicant> listAllApplicants();
	
}
