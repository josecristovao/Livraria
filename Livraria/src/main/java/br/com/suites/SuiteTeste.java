package br.com.suites;

import static br.com.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.test.LivrariaTeste;

@RunWith(Suite.class)
@SuiteClasses({ 
	LivrariaTeste.class

})
public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo() {
		killDriver();
	}

}
