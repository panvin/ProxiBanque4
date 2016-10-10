package com.sbev.proxibanque.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.sbev.proxibanque.domaine.Client;
import com.sbev.proxibanque.service.ClientService;
import com.sbev.proxibanque.service.CompteService;
import com.sbev.proxibanque.service.ConseillerService;
import com.sbev.proxibanque.service.GerantService;

@Controller
public class HomePageController extends AbstractController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private ConseillerService conseillerService;
	@Autowired
	private GerantService gerantService; 
	@Autowired
	private CompteService compteService; 
	
	

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

	public GerantService getGerantService() {
		return gerantService;
	}

	public void setGerantService(GerantService gerantService) {
		this.gerantService = gerantService;
	}

	public CompteService getCompteService() {
		return compteService;
	}

	public void setCompteService(CompteService compteService) {
		this.compteService = compteService;
	}
	
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

	List<Client> listeClient = clientService.lireToutClient();
	System.out.println(listeClient);
	return new ModelAndView("conseiller/clients", "clients", listeClient);
	
}
}