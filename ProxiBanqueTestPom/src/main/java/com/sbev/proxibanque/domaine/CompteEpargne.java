package com.sbev.proxibanque.domaine;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Méthode de la couche Domaine
 * Classe permettant de stocker toutes les informations relatives aux comptes epargnes. Classe fille de la classe Compte
 * 
 * @author Sylvain CHAUVET
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

//	@OneToOne(cascade=CascadeType.MERGE)
//	private Client client;
	
	/**
	 * Constructeur de la classe
	 * @param idCompte L'identifiant du compte (int)
	 * @param type Le type de compte (Epargne ou Courant - de type String)
	 * @param solde Le solde du compte à créer (double)
	 */
	public CompteEpargne(int idCompte, String type, double solde) {
		super(idCompte, "Epargne", solde);
	}
	
	/**
	 * Constructeur de la classe
	 * @param type Le type de compte (Epargne ou Courant - de type String)
	 * @param solde Le solde du compte à créer (double)
	 */
	public CompteEpargne(String type, double solde) {
		super("Epargne", solde);
	}
	
	/**
	 * Constructeur par défaut
	 */
	public CompteEpargne() {
		super();
	}
//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}
	
}
