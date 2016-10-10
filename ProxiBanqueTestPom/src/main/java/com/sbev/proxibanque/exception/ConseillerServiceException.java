package com.sbev.proxibanque.exception;

/**
 * Classe d'exception personnalisee pour la classe CoonseillerService
 * Cette classe permet  de gerer les exceptions causees par ConseillerService
 * @author VIncent PANOUILLERES
 *
 */
public class ConseillerServiceException extends Exception {
	
	private static final long serialVersionUID = -2140652444662783112L;

	/**
	 * Constructeur par defaut de la classe 
	 */
	public ConseillerServiceException(){
		super();
	}
	
	/**
	 * Constructeur de la classe prenant en compte les d�tails de l'erreur
	 * @param details Les details de l'erruer sous forme de chaine de caractere (String)
	 */
	public ConseillerServiceException(String details){
		super(details);
	}
	
	/**
	 * Constructeur de la classe prenant en compte les details de l'erreur et la cause de l'erreur
	 * @param message Le message d'erruer (String)
	 * @param cause La cause de l'erreur (Throwable)
	 */
	public ConseillerServiceException(String message, Throwable cause) { 
		super(message, cause); 
	}
	
	/**
	 * Constructeur de la classe, prend en compte les cause de l'erreur
	 * @param cause La cause de l'erreur (Throwable)
	 */
	public ConseillerServiceException(Throwable cause) {
		super(cause);
	}

}