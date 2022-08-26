package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetry {
	
	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyser.class)
	public void test2() {
		System.out.println("This is test 2");
//		int i=1/0;
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyser.class)
	public void test3() {
		System.out.println("This is test 3");
		Assert.assertTrue(0>1);
	}

}
