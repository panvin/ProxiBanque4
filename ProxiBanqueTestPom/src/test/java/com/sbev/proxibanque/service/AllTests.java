package com.sbev.proxibanque.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClientServiceTest.class, CompteServiceTest.class, ConseillerServiceTest.class,
		GerantServiceTest.class })
public class AllTests {

}
