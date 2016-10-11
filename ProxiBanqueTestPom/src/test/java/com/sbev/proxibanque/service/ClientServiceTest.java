package com.sbev.proxibanque.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sbev.proxibanque.dao.IClientDao;
import com.sbev.proxibanque.domaine.Client;

public class ClientServiceTest {

	@Mock
	private IClientDao clientDao;
	private ClientService clientService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		clientService = new ClientService();
		clientService.setClientDao(clientDao);
	}
	
	@Test
	public void testSauverClient() {
		Client cltReturned;
		Client clt = new Client("vincent", "panouilleres", "test", "test@test.com", null);
		when( clientDao.saveAndFlush(clt) ).thenReturn( clt );
		cltReturned = clientService.sauverClient(clt);
		Assert.assertNotNull(cltReturned);
		
	}

	@Test
	public void testLireClient() {
		Client cltReturned;
		Client clt = new Client("vincent", "panouilleres", "test", "test@test.com", null);
		when(clientDao.findByIdClient(4)).thenReturn(clt);
		cltReturned = clientService.lireClient(4);
		Assert.assertNotNull(cltReturned);
	}

	@Test
	public void testLireToutClient() {
		ArrayList<Client> liste;
		ArrayList<Client> liste2 = new ArrayList<Client>();
		Client clt = new Client("vincent", "panouilleres", "test", "test@test.com", null);
		liste2.add(clt);
		when(clientDao.findAll()).thenReturn(liste2);
		liste = (ArrayList<Client>) clientService.lireToutClient();
		Assert.assertNotNull(liste);
		
	}
}
