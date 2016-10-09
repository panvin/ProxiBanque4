package com.sbev.proxibanque.domaine;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe de la couche domaine
 * Cette classe regroupe l'ensemble des infos utiles au gérant. Cette classe herite de la classe conseiller
 * @author Sylvain CHAUVET
 *
 */
@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Conseiller {

	/**
	 *  Constructeur par défaut
	 */
	public Gerant() {
		super();
	}

	/**
	 * Constructeur de la classe
	 * @param idEmploye L'identifiant de l'employe (int)
	 * @param prenom Le prenom de l'employe (String)
	 * @param nom Le nom de l'employe (String)
	 * @param login Le login de l'employe (String)
	 * @param password Le mot de passe de l'employe (String)
	 * @param clients La liste des clients affiliés au conseiller (List d'objets de type Client)
	 */
	public Gerant(int idEmploye, String prenom, String nom, String login, String password, List<Client> clients) {
		super(idEmploye, prenom, nom, login, password, clients);
	}

	/**
	 * Constructeurd e la classe
	 * @param prenom Le prenom de l'employe (String)
	 * @param nom Le nom de l'employe (String)
	 * @param login Le login de l'employe (String)
	 * @param password Le mot de passe de l'employe (String)
	 * @param clients La liste des clients affiliés au conseiller (List d'objets de type Client)
	 */
	public Gerant(String prenom, String nom, String login, String password, List<Client> clients) {
		super(prenom, nom, login, password, clients);
	}

	/**
	 * Constructeur de la classe
	 * @param prenom Le prenom de l'employe (String)
	 * @param nom Le nom de l'employe (String)
	 * @param login Le login de l'employe (String)
	 * @param password Le mot de passe de l'employe (String)
	 */
	public Gerant(String prenom, String nom, String login, String password) {
		super(prenom, nom, login, password);
	}
}
