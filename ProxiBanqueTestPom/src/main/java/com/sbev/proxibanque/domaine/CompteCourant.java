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
 * Classe permettant de stocker toutes les informations relatives aux comptes courants. Classe fille de la classe Compte
 * 
 * @author Sylvain CHAUVET
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

//	@OneToOne(cascade=CascadeType.MERGE)
//	private Client client;
	

	/**
	 * Constructeur de la classe
	 * @param idCompte L'identifiant du compte (int)
	 * @param type Le type de compte (Epargne ou Courant - de type String)
	 * @param solde Le solde du compte à créer (double)
	 */
	public CompteCourant(int idCompte, String type, double solde) {
		super(idCompte, "Courant", solde);
	}
	
	/**
	 * Constructeur de la classe
	 * @param type Le type de compte (Epargne ou Courant - de type String)
	 * @param solde Le solde du compte à créer (double)
	 */
	public CompteCourant(String type, double solde) {
		super("Courant", solde);
	}
	
	/**
	 * Constructeur par défaut
	 */
	public CompteCourant() {
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
