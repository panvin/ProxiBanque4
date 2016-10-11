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
import com.sbev.proxibanque.service.ClientService;
import com.sbev.proxibanque.service.ConseillerService;


@Controller
@ManagedBean(name="conseillerBean")
@SessionScoped
public class ConseillerBean implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientService clientService;
	@Autowired
	private ConseillerService conseillerService;

    /**
     * 
     */
    private String login;
    private String password;
//    private String searchUser;
    private List<Client> clientList;
    private Conseiller conseiller;
    private Client client;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
    
    
    public ConseillerBean() {
		super();
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
    
    
    
    
//    public Collection<Client> getSearchUsersResults()
//    {
//        return searchUsersResults;
//    }
//    public void setSearchUsersResults(Collection<Client> searchUsersResults)
//    {
//        this.searchUsersResults = searchUsersResults;
//    }
//    public String getSearchUser()
//    {
//        return searchUser;
//    }
//    public void setSearchUser(String searchUser)
//    {
//        this.searchUser = searchUser;
//    }
    
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
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}



	/**
     * @return the page login.xhtml or home.xhtml if the condition is true or false
     */
    public String login1()
    {
    	boolean a = conseillerService.estValide(login, password);
        if(a == true)
        {
        	conseiller = conseillerService.lireConseillerParLogin(login);
        	setClientList(clientService.lireClientParConseiller(conseiller));
            return "conseiller/clients";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("login", new FacesMessage("L'identifiant ou le mot de passe saisi est invalide"));
            return "login";
        }
    }
    
    /**
     * @return the page home.xhtml
     */
//    public String searchUser()
//    {
//        String login = (this.searchUser == null)? "":this.searchUser.trim();        
//        this.searchUsersResults = clientService.searchUser(login);
//        System.out.println("Notre liste contient: "+searchUsersResults.size());
//       return "home";
//    }
    
    public List<Client> clientList1(){
    	return clientService.lireClientParConseiller(conseillerService.lireConseillerParLogin(login));
    }
    
    public void rowSelect(SelectEvent event){
    	client =  (Client)event.getObject();
    	System.out.println("selectedUser = "+client.getNom());	
    }
   
    
    
    
    
    
    public void onUserSelect(SelectEvent event){ 
    	this.client =  (Client)event.getObject();
    	System.out.println("selectedUser = "+client.getNom());
    }
    
    public void onUserUnselect(UnselectEvent event)
    {
    	client =  null;
    }
    
    public String sauverClient() {
		clientService.sauverClient(client);
		return "clients";
	}
    
//	public String createUser()
//	{
//		clientservice.create(nom, prenom, adresse, email, soldeCourant, soldeEpargne, conseillerservice.read(login));
//		return "home";
//	}
}
