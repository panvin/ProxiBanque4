package com.sbev.proxibanque.exception;

/**
 * Classe d'exception personnalis�e pour la classe ClientService
 * Cette classe permet  de g�rer les exceptions caus�es par ClientService
 * @author VIncent PANOUILLERES
 *
 */
public class ClientServiceException extends Exception {
	
	private static final long serialVersionUID = -2140652444662783112L;

	/**
	 * Constructeur par d�faut de la classe 
	 */
	public ClientServiceException(){
		super();
	}
	
	/**
	 * Constructeur de la classe prenant en compte les d�tails de l'erreur
	 * @param details Les d�tails de l'erruer sous forme de chaine de caractere (String)
	 */
	public ClientServiceException(String details){
		super(details);
	}
	
	/**
	 * Constructeur de la classe prenant en compte les d�tails de l'erreur et la cause de l'erreur
	 * @param message Le message d'erruer (String)
	 * @param cause La cause de l'erreur (Throwable)
	 */
	public ClientServiceException(String message, Throwable cause) { 
		super(message, cause); 
	}
	
	/**
	 * Constructeur de la classe, prend en compte les cause de l'erreur
	 * @param cause La cause de l'erreur (Throwable)
	 */
	public ClientServiceException(Throwable cause) {
		super(cause);
	}

}