package com.sbev.proxibanque.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Classe de la couche Domaine
 * Regroupe l'ensemble des informations relatives aux personne. Classe mère des classes Client et conseiller.
 * @author Sylvain CHAUVET
 *
 */
@MappedSuperclass
//@Entity
//@DiscriminatorValue("PERSONNE")
//@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Personne {
	
	private String prenom;
	private String nom;
	
	/**
	 * COnstructeur de la classe
	 * @param prenom Le prenom de la personne
	 * @param nom Le nom de la personne
	 */
	public Personne(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}
	
	/**
	 * Constructeur par defaut. 
	 */
	public Personne() {
		super();
	}

	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}
