package com.esprit.microservice.recruiterservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.exception.UserNotFoundException;

import java.util.UUID;
import javax.transaction.Transactional;

@Service
public class RecruiterService {
	@Autowired
	private RecruiterRepository recruiterRepository;
	
	public Recruiter addRecruiter(Recruiter recruiter) {
		return recruiterRepository.save(recruiter);
	}
	
    public List<Recruiter> findAllRecruiters() {
        return recruiterRepository.findAll();
    }
    

    public Recruiter findRecruiterById(Long id) {
        return recruiterRepository.findRecruiterById(id)
        		.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
	
	public Recruiter updateRecruiter(int id, Recruiter newRecruiter) {
		if (recruiterRepository.findById(id).isPresent()) {
			Recruiter existingRecruiter = recruiterRepository.findById(id).get();
			existingRecruiter.setNom(newRecruiter.getNom());
			existingRecruiter.setPrenom(newRecruiter.getPrenom());
			existingRecruiter.setPoste(newRecruiter.getPoste());
			existingRecruiter.setNumtelephone(newRecruiter.getNumtelephone());

			return recruiterRepository.save(existingRecruiter);
		} else
			return null;
	}
	
	public String deleteRecruiter(int id) {
		if (recruiterRepository.findById(id).isPresent()) {
			recruiterRepository.deleteById(id);
			return "recruiter deleted";
		} else
			return "recruiter cannot be deleted";
	}
}
