package com.sbev.proxibanque.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.sbev.proxibanque.dao.IConseillerDao;
import com.sbev.proxibanque.domaine.Conseiller;


@RunWith(MockitoJUnitRunner.class)
public class ConseillerServiceTest {
	
	@Mock
	private IConseillerDao conseillerDao;
	private ConseillerService conseillerService;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		conseillerService = new ConseillerService();
		conseillerService.setConseillerDao(conseillerDao);
	}
	
	@Test
	public void testSauverConseiller() {
		Conseiller consReturned;
		Conseiller csl = new Conseiller("vincent", "panouilleres", "vpanouilleres", "test");
		when( conseillerDao.saveAndFlush(csl) ).thenReturn( csl );
		consReturned = conseillerService.sauverConseiller(csl);
		Assert.assertNotNull(consReturned);
		
	}

	@Test
	public void testLireConseiller() {
		Conseiller consReturned;
		Conseiller csl = new Conseiller("vincent", "panouilleres", "vpanouilleres", "test");
		when(conseillerDao.findByIdEmploye(4)).thenReturn(csl);
		consReturned = conseillerService.lireConseiller(4);
		Assert.assertNotNull(consReturned);
	}

	@Test
	public void testLireToutConseiller() {
		ArrayList<Conseiller> liste;
		ArrayList<Conseiller> liste2 = new ArrayList<Conseiller>();
		Conseiller csl = new Conseiller("vincent", "panouilleres", "vpanouilleres", "test");
		liste2.add(csl);
		when(conseillerDao.findAll()).thenReturn(liste2);
		liste = (ArrayList<Conseiller>) conseillerService.lireToutConseiller();
		Assert.assertNotNull(liste);
	}
}
