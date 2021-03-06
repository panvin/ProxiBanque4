package com.sbev.proxibanque.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sbev.proxibanque.domaine.Client;
import com.sbev.proxibanque.domaine.Conseiller;
import com.sbev.proxibanque.domaine.Gerant;
import com.sbev.proxibanque.domaine.Virement;
import com.sbev.proxibanque.service.ClientService;
import com.sbev.proxibanque.service.CompteService;
import com.sbev.proxibanque.service.ConseillerService;
import com.sbev.proxibanque.service.GerantService;


/**
 * Classe permettant de gerer le gerant a partir de l'ihm.
 * @author Brice Tardy et Elise Patteyn
 *
 */
@Controller
@ManagedBean(name = "gerantBean")
@SessionScoped
public class GerantBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@Autowired
	private ClientService clientService;
	@Autowired
	private ConseillerService conseillerService;
	@Autowired
	private GerantService gerantService; 
	@Autowired
	private CompteService compteService;

    /**
     * 
     */
    private String login;
    private String password;
//    private String searchUser;
    private List<Client> clientList;
    private List<Conseiller> conseillerList;
    private List<Virement> virementList;
    private Gerant gerant;
    private Conseiller conseiller; 
    private Client client;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
    
    
    public GerantBean() {
		super();
	}
    
    
    
    public CompteService getCompteService() {
		return compteService;
	}



	public void setCompteService(CompteService compteService) {
		this.compteService = compteService;
	}



	public List<Virement> getVirementList() {
		return virementList;
	}



	public void setVirementList(List<Virement> virementList) {
		this.virementList = virementList;
	}



	public GerantService getGerantService() {
		return gerantService;
	}



	public void setGerantService(GerantService gerantService) {
		this.gerantService = gerantService;
	}



	public ClientService getClientService() {
		return clientService;
	}



	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}



	public ConseillerService getConseillerService() {
		return conseillerService;
	}



	public void setConseillerService(ConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}



	public List<Conseiller> getConseillerList() {
		return conseillerList;
	}



	public void setConseillerList(List<Conseiller> conseillerList) {
		this.conseillerList = conseillerList;
	}



	public Gerant getGerant() {
		return gerant;
	}



	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<Client> getClientList() {
		return clientList;
	}
	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	public String getLogin()
    {
        return login;
    }
	public void setLogin(String username)
    {
        this.login = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public Client getClient()
    {
        if(client == null){
            client = new Client();
        }
        return client;
    }
    public void setClient(Client client)
    {
        this.client = client;
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


	public Conseiller getConseiller() {
		if (conseiller == null) {
			conseiller = new Conseiller();
		}
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}



	/**
	 * Methode pour l'authentification
     * @return the page login.xhtml or home.xhtml if the condition is true or false
     */
    public String login1()
    {
    	boolean a = gerantService.estValide(login, password);
        if(a == true)
        {
        	gerant = gerantService.lireGerantParLogin(login);
        	setConseillerList(conseillerService.lireToutConseiller());
        	setClientList(clientService.lireClientParConseiller(conseiller));
        	setVirementList(compteService.lireToutVirement());
            return "gerant/conseillers";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("login", new FacesMessage("L'identifiant ou le mot de passe saisi est invalide"));
            return "login";
        }
    }
    
    
    public List<Client> clientList1(){
    	return clientService.lireClientParConseiller(conseillerService.lireConseillerParLogin(login));
    }
    
    /**
     * Selection de ligne dans une table
     * @param event
     */
    public void rowSelect(SelectEvent event){
    	client =  (Client)event.getObject();
    	System.out.println("selectedUser = "+client.getNom());	
    }
   
    public List<Conseiller> conseillerList1() {
    	return conseillerService.lireToutConseiller(); 
    }
    
    
    
    
    /**
     * Methode permettant la selection d'un utilisateur
     * @param event
     */
    public void onUserSelect(SelectEvent event){ 
    	this.conseiller =  (Conseiller)event.getObject();
    	System.out.println("selectedUser = "+conseiller.getNom());
    }
    
    /**
     * Methode permettant la selection d'un utilisateur
     * @param event
     */
    public void onUserUnselect(UnselectEvent event)
    {
    	conseiller =  null;
    }
    
    /**
     * Methode permettant de sauver un conseiller
     * @return Redirection
     */
    public String sauverConseiller() {
		conseillerService.sauverConseiller(conseiller);
		return "gerant/conseillers";
	}
}