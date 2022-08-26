package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenersTest {

	@Test
	public void testListeners1() {

		System.out.println("I am inside test 1");
	}

	@Test
	public void testListeners2() {

		System.out.println("I am inside test 2");
	}

	@Test
	public void testListeners3() {

		System.out.println("I am inside test 3");
		throw new SkipException("This test is skipped");
	}
}
