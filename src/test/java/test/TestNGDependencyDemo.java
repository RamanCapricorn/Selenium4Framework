package test;

import org.testng.annotations.Test;

//public class TestNGDependencyDemo {
//	
//	@Test(dependsOnMethods = {"test2","test3"}, priority = 1)
//	public void test1() {
//		System.out.println("This is Test 1");
//	}
//	
//	@Test(priority = 2)
//	public void test2() {
//		System.out.println("This is Test 2");
//	}
//	
//	@Test(priority = 2)
//	public void test3() {
//		System.out.println("This is Test 3");
//	}
//}

//
//public class TestNGDependencyDemo {
//	
//	@Test(dependsOnGroups = {"sanity1"}, priority = 1)
//	public void test1() {
//		System.out.println("This is Test 1");
//	}
//	
//	@Test(groups = "sanity1")
//	public void test2() {
//		System.out.println("This is Test 2");
//	}
//	
//	@Test(priority = 2)
//	public void test3() {
//		System.out.println("This is Test 3");
//	}
//}



public class TestNGDependencyDemo {
	
	@Test(dependsOnGroups = {"sanity.*"}, priority = 1)
	public void test1() {
		System.out.println("This is Test 1");
	}
	
	@Test(groups = "sanity1")
	public void test2() {
		System.out.println("This is Test 2");
	}
	
	@Test(groups = "sanity2")
	public void test3() {
		System.out.println("This is Test 3");
	}
}