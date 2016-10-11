package com.sbev.proxibanque.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sbev.proxibanque.domaine.Client;
import com.sbev.proxibanque.domaine.CompteCourant;
import com.sbev.proxibanque.domaine.CompteEpargne;
import com.sbev.proxibanque.domaine.Conseiller;
import com.sbev.proxibanque.service.ClientService;


@Controller
@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientService clientService;

	private Client client;
	private Conseiller conseiller;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private CompteCourant courant;
	private CompteEpargne epargne;
	

	public ClientBean() {
		super();
		
		//this.conseiller = clientService.lireConseillerParClient(client);
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CompteCourant getCourant() {
		return courant;
	}

	public void setCourant(CompteCourant courant) {
		this.courant = courant;
	}

	public CompteEpargne getEpargne() {
		return epargne;
	}

	public void setEpargne(CompteEpargne epargne) {
		this.epargne = epargne;
	}

//	public String sauverClient() {
//		ConseillerBean conseillerinsession = (ConseillerBean) FacesContext.getCurrentInstance().getExternalContext()
//				.getSessionMap().get("conseillerBean");
//		clientService.sauverClient(conseillerinsession.getClient());
//		conseillerinsession.setClientList(clientService.lireClientParConseiller(conseillerinsession.getConseiller()));
//		return "clients";
//	}
	
	public String creerClient() {
		ConseillerBean conseillerinsession = (ConseillerBean) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("conseillerBean");
		clientService.sauverClient(client);
		conseillerinsession.setClientList(clientService.lireClientParConseiller(conseillerinsession.getConseiller()));
		return "clients";
	}

//	public String supprimerClient(Client client) {
//		ConseillerBean conseillerinsession = (ConseillerBean) FacesContext.getCurrentInstance().getExternalContext()
//				.getSessionMap().get("conseillerBean");
//		clientService.supprimerClient(client);
//		conseillerinsession.setClientList(clientService.lireClientParConseiller(conseillerinsession.getConseiller()));
//		return "clients";
//	}
	

}
