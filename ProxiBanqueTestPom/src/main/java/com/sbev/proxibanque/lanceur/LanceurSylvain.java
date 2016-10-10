package com.sbev.proxibanque.lanceur;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sbev.proxibanque.domaine.Client;
import com.sbev.proxibanque.domaine.CompteCourant;
import com.sbev.proxibanque.domaine.CompteEpargne;
import com.sbev.proxibanque.domaine.Conseiller;
import com.sbev.proxibanque.domaine.Gerant;
import com.sbev.proxibanque.domaine.Virement;
import com.sbev.proxibanque.service.ClientService;
import com.sbev.proxibanque.service.CompteService;
import com.sbev.proxibanque.service.ConseillerService;
import com.sbev.proxibanque.service.GerantService;

public class LanceurSylvain {

	public static void main(String[] args) {
		
	// 1. Chargement du conteneur en 4.0.0
	//ApplicationContext appContext = (ApplicationContext) new ClassPathXmlApplicationContext("servlet.xml");
	
	// 2. Récupération des beans
	//ClientService clientService = (ClientService) appContext.getBean("clientService");
	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("proxibanque-data.xml");
	
//	IClientDao dao = (IClientDao) appContext.getBean("clientDao");
//	IGerantDao gDao = (IGerantDao) appContext.getBean("gerantDao");
//	IConseillerDao cDao = (IConseillerDao) appContext.getBean("conseillerDao");
	ClientService clientService = (ClientService) appContext.getBean("clientService");
	ConseillerService conseillerService = (ConseillerService) appContext.getBean("conseillerService");
	CompteService compteService = (CompteService) appContext.getBean("compteService");
	GerantService gerantService = (GerantService) appContext.getBean("gerantService");

	Conseiller conseiller1 = new Conseiller("Abra", "Kadabra", "abra", "kadabra");
	conseillerService.sauverConseiller(conseiller1);
	CompteEpargne compte1 = new CompteEpargne("jij", 2158.4);
	compteService.sauverCompte(compte1);
	Client client1 = new Client ("Bob", "Dylan", "2 rue des champignons", "dylan@gmail.com", compte1, conseiller1);
	clientService.sauverClient(client1);
	
	
	Gerant gerant1 = new Gerant("Magic", "Gerant", "magic", "gerant");
	conseillerService.sauverConseiller(gerant1);
	CompteCourant compte2 = new CompteCourant("jij", 29.4);
	compteService.sauverCompte(compte2);
	Client client2 = new Client ("Mike", "Tyson", "3 rue du Redemarrage Eclipse", "banzai@gmail.com", compte2, gerant1);
	clientService.sauverClient(client2);

	Conseiller conseiller = conseillerService.lireConseiller(1);
	CompteCourant compte3 = new CompteCourant("jij", 3529.4);
	compteService.sauverCompte(compte3);
	Client client3 = new Client ("Francis", "Lalane", "12 avenue du boucan", "flalane@gmail.com", compte3, conseiller);
	clientService.sauverClient(client3);
	
	compteService.virement(1, 2, 227);
	
	List<Client> listeClient = clientService.lireToutClient();
	for (Client client : listeClient) {
		System.out.println(client.getPrenom() + " " + client.getNom());
	}


	

	
	}
}
