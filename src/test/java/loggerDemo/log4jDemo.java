package loggerDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;

public class log4jDemo {

	private static Logger logger = LogManager.getLogger(log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n------ Hello World.------ \n");
		
		logger.trace("This is a trace message");
		logger.debug("This is a debug message");
		logger.info("This is a info message.");
		logger.error("This is a error message.");
		logger.warn("This is a warn message.");
		logger.fatal("This is a fatal message.");
		
		System.out.println("\n------- Completed.------- \n");
	}
}
