package com.sbev.proxibanque.domaine;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Méthode de la couche Domaine
 * Classe abstraite, mère des classes comptes courants et comptes epargne
 * 
 * @author Sylvain CHAUVET
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCompte;
	private String type;
	private double solde;
	
	
	/**
	 * Constructeur de la classe
	 * @param idCompte L'identifiant du compte (int)
	 * @param type Le type de compte (Epargne ou Courant - de type String)
	 * @param solde Le solde du compte à créer (double)
	 */
	public Compte(int idCompte, String type, double solde) {
		super();
		this.idCompte = idCompte;
		this.type = type;
		this.solde = solde;
	}
	
	/**
	 * Constructeur de la classe
	 * @param type Le type de compte (Epargne ou Courant - de type String)
	 * @param solde Le solde du compte à créer (double)
	 */
	public Compte(String type, double solde) {
		super();
		this.type = type;
		this.solde = solde;
	}
	
	/**
	 * Constructeur par défaut.
	 */
	public Compte() {
		super();
	}
	
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}	
}
