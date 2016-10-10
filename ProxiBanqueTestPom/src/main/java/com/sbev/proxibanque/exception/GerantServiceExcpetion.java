package com.sbev.proxibanque.exception;

/**
 * Classe d'exception personnalisee pour la classe GerantService
 * Cette classe permet  de gerer les exceptions causees par GerantService
 * @author VIncent PANOUILLERES
 *
 */
public class GerantServiceExcpetion extends Exception {
	
	private static final long serialVersionUID = -2140652444662783112L;

	/**
	 * Constructeur par defaut de la classe 
	 */
	public GerantServiceExcpetion(){
		super();
	}
	
	/**
	 * Constructeur de la classe prenant en compte les details de l'erreur
	 * @param details Les details de l'erruer sous forme de chaine de caractere (String)
	 */
	public GerantServiceExcpetion(String details){
		super(details);
	}
	
	/**
	 * Constructeur de la classe prenant en compte les details de l'erreur et la cause de l'erreur
	 * @param message Le message d'erruer (String)
	 * @param cause La cause de l'erreur (Throwable)
	 */
	public GerantServiceExcpetion(String message, Throwable cause) { 
		super(message, cause); 
	}
	
	/**
	 * Constructeur de la classe, prend en compte les cause de l'erreur
	 * @param cause La cause de l'erreur (Throwable)
	 */
	public GerantServiceExcpetion(Throwable cause) {
		super(cause);
	}

}