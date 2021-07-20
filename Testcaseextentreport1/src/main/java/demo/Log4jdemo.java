package demo;

import org.apache.logging.log4j.Logger;

public class Log4jdemo {
	
	private static Logger logger = org.apache.logging.log4j.LogManager.getLogger(Log4jdemo.class);

	public static void main(String[] args) {
		System.out.println("hello world....");
		
		logger.info("Information Message");
		logger.error("ErrorMessage");
		logger.warn("warnMessage");
		logger.fatal("fatalMessage");
		logger.trace("Trace Message");
		
		System.out.println("Completed");
		

	}

}
