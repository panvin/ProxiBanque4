package com.sbev.proxibanque.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sbev.proxibanque.domaine.Compte;
import com.sbev.proxibanque.service.CompteService;


@Controller
@ManagedBean(name="compteBean")
@SessionScoped
public class CompteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CompteService compteService;
	
	
	private Compte compte;
	
	
	public CompteBean() {
		super();
	}
	
//	private double soldeCourant = (double) compteservice.read(iDCourant).getSolde();
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
}
