package tw.com.orangice.sf.lib.log;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class LogService {
	static LogService instance = null;
	static Logger defaultLogger = null;
	String topic = "";
	public LogService(File path, String topic){
		PropertyConfigurator.configure(path.getAbsolutePath());
		
		defaultLogger = Logger.getLogger(topic);
		instance = this;
	}
	public static LogService getInstance(){
		return instance;
	}
	/*
	public static Logger getLogger(String topic){
		
		Logger logger = Logger.getLogger(topic);
		return logger;
	}
	public static Logger getLogger(){
		
		return defaultLogger;
	}
	*/
	public static void info(String tag, String className, String methodName, String description){
		defaultLogger.info(tag+":["+className+":"+methodName+"]:"+description);
	}
	public static void info(String tag, String className, String methodName, String description, Throwable t){
		defaultLogger.info(tag+":["+className+":"+methodName+"]:"+description, t);
		
	}
	public static void debug(String tag, String className, String methodName, String description){
		defaultLogger.debug(tag+":["+className+":"+methodName+"]:"+description);
		System.out.println(tag+":["+className+":"+methodName+"]:"+description);
	}
	public static void debug(String tag, String className, String methodName, String description, Throwable t){
		defaultLogger.debug(tag+":["+className+":"+methodName+"]:"+description, t);
		
	}
	public static void error(String tag, String className, String methodName, String description){
		defaultLogger.error(tag+":["+className+":"+methodName+"]:"+description);
		
	}
	public static void error(String tag, String className, String methodName, String description, Throwable t){
		defaultLogger.error("["+className+":"+methodName+"]:"+description, t);
		
	}
}
