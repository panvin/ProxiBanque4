package com.sbev.proxibanque.presentation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
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
import com.sbev.proxibanque.service.ClientService;
import com.sbev.proxibanque.service.ConseillerService;
import com.sbev.proxibanque.service.GerantService;


@Controller
@ManagedBean(name = "gerantBean")
@SessionScoped
public class GerantBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GerantService gerantService;
	@Autowired
	private ConseillerService conseillerService;
	@Autowired
	private ClientService clientService;

	/**
	 * 
	 */
	private String login;
	private String password;
	// private String searchUser;
	private List<Client> clientList;
	private List<Conseiller> conseillerList;
	private Gerant gerant; 

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Conseiller> getConseillerList() {
		return conseillerList;
	}

	public void setConseillerList(List<Conseiller> conseillerList) {
		this.conseillerList = conseillerList;
	}

	private Conseiller conseiller;
	private Client client;

	public GerantBean() {
		super();
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String username) {
		this.login = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		if (client == null) {
			client = new Client();
		}
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// public Collection<Client> getSearchUsersResults()
	// {
	// return searchUsersResults;
	// }
	// public void setSearchUsersResults(Collection<Client> searchUsersResults)
	// {
	// this.searchUsersResults = searchUsersResults;
	// }
	// public String getSearchUser()
	// {
	// return searchUser;
	// }
	// public void setSearchUser(String searchUser)
	// {
	// this.searchUser = searchUser;
	// }

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
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
    
//	public String createUser()
//	{
//		clientservice.create(nom, prenom, adresse, email, soldeCourant, soldeEpargne, conseillerservice.read(login));
//		return "home";
//	}
}
