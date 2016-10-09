package com.sbev.proxibanque.domaine;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * Classe de la couche domaine
 * Cette classe regroupe l'ensemble des infos utiles aux conseillers. Cette classe herite de la classe personne
 * @author Sylvain CHAUVET
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ROLE")
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEmploye;
	private String login;
	private String password;
	@OneToMany(targetEntity=Client.class, mappedBy="conseiller")
	private List<Client> clients;
	
	
	/**
	 * Constructeur de la classe
	 * @param idEmploye L'identifiant de l'employe (int)
	 * @param prenom Le prenom de l'employe (String)
	 * @param nom Le nom de l'employe (String)
	 * @param login Le login de l'employe (String)
	 * @param password Le mot de passe de l'employe (String)
	 * @param clients La liste des clients affiliés au conseiller (List d'objets de type Client)
	 */
	public Conseiller(int idEmploye, String prenom, String nom, String login, String password, List<Client> clients) {
		super(prenom, nom);
		this.idEmploye = idEmploye;
		this.login     = login;
		this.password  = password;
		this.clients   = clients;
	}
	
	/**
	 * Constructeurd e la classe
	 * @param prenom Le prenom de l'employe (String)
	 * @param nom Le nom de l'employe (String)
	 * @param login Le login de l'employe (String)
	 * @param password Le mot de passe de l'employe (String)
	 * @param clients La liste des clients affiliés au conseiller (List d'objets de type Client)
	 */
	public Conseiller(String prenom, String nom, String login, String password, List<Client> clients) {
		super(prenom, nom);
		this.login = login;
		this.password = password;
		this.clients = clients;
	}
	
	/**
	 * Constructeur de la classe
	 * @param prenom Le prenom de l'employe (String)
	 * @param nom Le nom de l'employe (String)
	 * @param login Le login de l'employe (String)
	 * @param password Le mot de passe de l'employe (String)
	 */
	public Conseiller(String prenom, String nom, String login, String password) {
		super(prenom, nom);
		this.login = login;
		this.password = password;
	}
	
	/**
	 *  Constructeur par défaut de la classe
	 */
	public Conseiller() {
		super();
	}
	
	public int getIdEmploye() {
		return idEmploye;
	}
	
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}	
}
