package com.sbev.proxibanque.domaine;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe de la couche domaine
 * Contient l'ensemble des elements relatifs aux virements. Cette classe permet de garder un historique des virement effectues
 * @author Sylvain CHAUVET
 *
 */
@Entity
public class Virement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idVirement;
	//changer UML
	private Timestamp date;
	//id ou compte ?
	private int idCompteDebiteur;
	private int idCompteCrediteur;
	private double montant;
	
	/**
	 * @param idVirement L'identifiant du virement (int)
	 * @param date La date du virement (Timestamp)
	 * @param idCompteDebiteur Identifianbt du compte a debiter (int)
	 * @param idCompteCrediteur vIdentifiant du compte a crediter (int)
	 * @param montant Le Montant du virement (double)
	 */
	public Virement(int idVirement, Timestamp date, int idCompteDebiteur, int idCompteCrediteur, double montant) {
		super();
		this.idVirement = idVirement;
		this.date = date;
		this.idCompteDebiteur = idCompteDebiteur;
		this.idCompteCrediteur = idCompteCrediteur;
		this.montant = montant;
	}
	
	/**
	 * Constructeur de la classe
	 * @param date La date du virement (Timestamp)
	 * @param idCompteDebiteur Identifianbt du compte a debiter (int)
	 * @param idCompteCrediteur vIdentifiant du compte a crediter (int)
	 * @param montant Le Montant du virement (double)
	 */
	public Virement(Timestamp date, int idCompteDebiteur, int idCompteCrediteur, double montant) {
		super();
		this.date = date;
		this.idCompteDebiteur = idCompteDebiteur;
		this.idCompteCrediteur = idCompteCrediteur;
		this.montant = montant;
	}
	
	/**
	 * Constructeur de la classe
	 * @param idCompteDebiteur Identifianbt du compte a debiter (int)
	 * @param idCompteCrediteur vIdentifiant du compte a crediter (int)
	 * @param montant Le Montant du virement (double)
	 */
	public Virement(int idCompteDebiteur, int idCompteCrediteur, double montant) {
		super();
		//TODO modifier la date pour afficher la date actuelle (now)
		this.date = null;
		this.idCompteDebiteur = idCompteDebiteur;
		this.idCompteCrediteur = idCompteCrediteur;
		this.montant = montant;
	}

	/**
	 * Constructeur par défaut
	 */
	public Virement() {
		super();
	}

	public int getIdVirement() {
		return idVirement;
	}
	
	public void setIdVirement(int idVirement) {
		this.idVirement = idVirement;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public int getIdCompteDebiteur() {
		return idCompteDebiteur;
	}
	
	public void setIdCompteDebiteur(int idCompteDebiteur) {
		this.idCompteDebiteur = idCompteDebiteur;
	}
	
	public int getIdCompteCrediteur() {
		return idCompteCrediteur;
	}
	
	public void setIdCompteCrediteur(int idCompteCrediteur) {
		this.idCompteCrediteur = idCompteCrediteur;
	}
	
	public double getMontant() {
		return montant;
	}
	
	public void setMontant(double montant) {
		this.montant = montant;
	}
}
