package DAO;

import java.util.List;

import com.sprint1db.entities.Applicant;
import com.sprint1db.exception.EntityNotFoundException;

public interface ApplicantDAO {
	Applicant addApplicant(Applicant applicant);
	Applicant updateApplicant(Applicant applicant);
	Applicant deleteApplicant(long id) throws EntityNotFoundException;
	Applicant listApplicantById(long id) throws EntityNotFoundException;
	List<Applicant> listAllApplicants();
}
