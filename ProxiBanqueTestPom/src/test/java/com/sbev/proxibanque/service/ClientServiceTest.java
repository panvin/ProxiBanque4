package com.sbev.proxibanque.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sbev.proxibanque.dao.IClientDao;
import com.sbev.proxibanque.domaine.Client;

import junit.framework.Assert;

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
		fail("Not yet implemented");
	}

	@Test
	public void testLireToutClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testSupprimerClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testLireClientParConseiller() {
		fail("Not yet implemented");
	}

}
