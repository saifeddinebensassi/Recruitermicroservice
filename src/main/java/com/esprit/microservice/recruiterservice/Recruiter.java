package com.esprit.microservice.recruiterservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Recruiter implements Serializable {
	private static final long serialVersionUID = 6711457437559348053L;
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom,poste;
	private int numtelephone;
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getNumtelephone() {
		return numtelephone;
	}
	public void setNumtelephone(int numtelephone) {
		this.numtelephone = numtelephone;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Recruiter(int id, String nom, String prenom, String poste) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.numtelephone = numtelephone;
	}
	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recruiter(String poste) {
		super();
		this.poste = poste;
	}
	
	
	 
	
}
