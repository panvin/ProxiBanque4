package com.sbev.proxibanque.domaine;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Méthode de la couche Domaine
 * Classe permettant de stocker toutes les informations relatives aux comptes courants. Classe fille de la classe Compte
 * 
 * @author Sylvain CHAUVET
 */
@Entity
@PrimaryKeyJoinColumn(name="COMPTE_ID")
public class CompteCourant extends Compte {

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

}
