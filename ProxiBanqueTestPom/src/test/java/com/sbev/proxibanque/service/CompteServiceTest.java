package com.sbev.proxibanque.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.sbev.proxibanque.dao.ICompteDao;

@RunWith(MockitoJUnitRunner.class)
public class CompteServiceTest {
	
	@Mock
	private ICompteDao compteDao;
	private CompteService compteService;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		compteService = new CompteService();
		compteService.setCompteDao(compteDao);
	}
	
	@Test
	public void testSauverCompte() {

	}

	@Test
	public void testLireCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testLireToutCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testSupprimerCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testVirement() {
		fail("Not yet implemented");
	}

}
