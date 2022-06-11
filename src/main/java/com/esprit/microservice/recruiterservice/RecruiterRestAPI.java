package com.esprit.microservice.recruiterservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/recruiters")
public class RecruiterRestAPI {
	
	@Autowired
	private RecruiterService recruiterService;
	
    @GetMapping("/all")
    public ResponseEntity<List<Recruiter>> getAllRecruiters () {
        List<Recruiter> recruiters = recruiterService.findAllRecruiters();
        return new ResponseEntity<>(recruiters, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Recruiter> getRecruiterById (@PathVariable("id") Long id) {
        Recruiter recruiter = recruiterService.findRecruiterById(id);
        return new ResponseEntity<>(recruiter, HttpStatus.OK);
    }
	
	@PostMapping (value = "/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Recruiter> createRecruiter(@RequestBody Recruiter recruiter) {
		return new ResponseEntity<>(recruiterService.addRecruiter(recruiter), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recruiter> updateRecruiter(@PathVariable(value = "id") int id,
    										@RequestBody Recruiter recruiter){
		return new ResponseEntity<>(recruiterService.updateRecruiter(id, recruiter), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteRecruiter(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(recruiterService.deleteRecruiter(id), HttpStatus.OK);
	}
	
	
	

}
