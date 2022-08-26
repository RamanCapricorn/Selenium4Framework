package test;

import org.testng.annotations.Test;

@Test(groups = "AllClassTests")
public class GroupTest {

	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println("I am in Test 1");
	}
	
	@Test(groups= {"sanity", "smoke"})
	public void test2() {
		System.out.println("I am in Test 2");
	}
	
	@Test(groups = {"regression"})
	public void test3() {
		System.out.println("I am in Test 3");
	}
	
	@Test
	public void test4() {
		System.out.println("I am in Test 4");
	}
	
	@Test(groups = {"windows.regression"})
	public void test5() {
		System.out.println("I am in Test 5");
	}
	
	@Test(groups = {"linux.regression"})
	public void test6() {
		System.out.println("I am in Test 6");
	}
	
	@Test(groups = {"windows.smoke"})
	public void test7() {
		System.out.println("I am in Test 7");
	}
}
