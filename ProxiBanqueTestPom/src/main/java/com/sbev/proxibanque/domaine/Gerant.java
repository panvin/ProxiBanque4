package com.sbev.proxibanque.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.sbev.proxibanque.domaine.Conseiller;

/**
 * Classe de la couche domaine
 * Cette classe regroupe l'ensemble des infos utiles au gérant. Cette classe herite de la classe conseiller
 * @author Sylvain CHAUVET
 *
 */
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="ROLE")
//@DiscriminatorValue("GERANT")
public class Gerant extends Conseiller {
	
	@OneToMany(targetEntity=Conseiller.class)
	private List<Conseiller> conseillerList;
	@OneToMany(targetEntity=Virement.class)
	private List<Virement> virementList;

	public List<Conseiller> getConseillerList() {
		return conseillerList;
	}

	public void setConseillerList(List<Conseiller> conseillerList) {
		this.conseillerList = conseillerList;
	}

	public List<Virement> getVirementList() {
		return virementList;
	}

	public void setVirementList(List<Virement> virementList) {
		this.virementList = virementList;
	}

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
	public Gerant(int idEmploye, String prenom, String nom, String login, String password, List<Client> clients, List<Conseiller> conseillers, List<Virement> virements) {
		super(idEmploye, prenom, nom, login, password, clients);
		this.conseillerList = conseillers;
		this.virementList= virements;
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
