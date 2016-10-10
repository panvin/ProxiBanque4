package com.sbev.proxibanque.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sbev.proxibanque.domaine.Client;
import com.sbev.proxibanque.domaine.Conseiller;
import com.sbev.proxibanque.service.ClientService;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean {

	private static final long serialVersionUID = 1L;

	ClientService clientService = new ClientService();

	private Client client;
	private Conseiller conseiller;

	public ClientBean() {
		super();
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

	public String sauverClient() {
		ConseillerBean conseillerinsession = (ConseillerBean) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("conseillerbean");
		clientService.sauverClient(client);
		conseillerinsession.setClientList(clientService.getTargetedClients(conseillerinsession.getConseiller()));
		return "clients";
	}

	public String supprimerClient(Client client) {
		ConseillerBean conseillerinsession = (ConseillerBean) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("conseillerbean");
		clientService.supprimerClient(client);
		conseillerinsession.setClientList(clientService.getTargetedClients(conseillerinsession.getConseiller()));
		return "clients";
	}

}
