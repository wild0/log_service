package tw.com.orangice.sf.lib.log;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class LogService {
	static Logger logger = null;
	public static void initial(File path){
		PropertyConfigurator.configure(path.getAbsolutePath());
		logger = Logger.getLogger("paperless");
	}
	public static Logger getLogger(){
		return logger;
	}
}
