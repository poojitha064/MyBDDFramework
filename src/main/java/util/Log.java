package util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class Log {
	public static String logFile = System.getProperty("user.dir")+"/target/";
	public static Logger logger;
	
	public void init(){
		 try {
	            logFile=logFile+"test.log";
	            FileHandler fh = new FileHandler(logFile);
	            logger = Logger.getLogger("sync test");
	            logger.addHandler(fh);
	            logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
	            SimpleFormatter formatter = new SimpleFormatter();
	            fh.setFormatter(formatter);
	        }catch (IOException e){

	        }

	    }
}
