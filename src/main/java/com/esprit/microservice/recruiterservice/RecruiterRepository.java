package com.esprit.microservice.recruiterservice;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecruiterRepository extends JpaRepository<Recruiter, Integer>{
	@Query("select r from Recruiter r where r.poste like :poste")
	public Page<Recruiter> recruiterByPoste(@Param("poste")String n,Pageable pageable); 
	
	 void deleteRecruiterById(Long id);

	    Optional<Recruiter> findRecruiterById(Long id);
	
}
