package test;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametersTest {
	
	@Parameters({"MyName"})
	@Test
	public void paramtest(@Optional("Raman") String name) {
		
		System.out.println(name);
	}

}
