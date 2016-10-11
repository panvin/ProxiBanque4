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
	private int idcomptedeb, idcomptecred;
	private double montant;
	
	private Compte compteDeb;
	private Compte compteCred;
	
	
	public CompteBean() {
		super();
	}
	
	
//	private double soldeCourant = (double) compteservice.read(iDCourant).getSolde();
	
	public CompteService getCompteService() {
		return compteService;
	}


	public void setCompteService(CompteService compteService) {
		this.compteService = compteService;
	}


	public int getIdcomptedeb() {
		return idcomptedeb;
	}


	public void setIdcomptedeb(int idcomptedeb) {
		this.idcomptedeb = idcomptedeb;
	}


	public int getIdcomptecred() {
		return idcomptecred;
	}


	public void setIdcomptecred(int idcomptecred) {
		this.idcomptecred = idcomptecred;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompteDeb() {
		return compteDeb;
	}


	public void setCompteDeb(Compte compteDeb) {
		this.compteDeb = compteDeb;
	}


	public Compte getCompteCred() {
		return compteCred;
	}


	public void setCompteCred(Compte compteCred) {
		this.compteCred = compteCred;
	}


	public String faireVirement() {
		compteService.virement(idcomptedeb, idcomptecred, montant);
		return "conseiller/clients";
	}
}
