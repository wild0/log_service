package tw.com.orangice.sf.lib.log;

import java.io.File;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.WriterAppender;
import org.json.JSONException;
import org.json.JSONObject;



public class LogService {
	static LogService instance = null;
	static Logger defaultLogger = null;
	String topic = "";
	
	public final static int LOG_INFO = 1;
	public final static int LOG_ERROR = 5;

	public LogService(File path, String topic) {
		PropertyConfigurator.configure(path.getAbsolutePath());

		defaultLogger = Logger.getLogger(topic);
		instance = this;
	}

	public LogService(String topic) {
		// PropertyConfigurator.configure(path.getAbsolutePath());

		defaultLogger = Logger.getLogger(topic);
		instance = this;
	}
	public static void appendFunctionLog(int type, String className, String functionName, String arg1) throws JSONException{
		JSONObject message = new JSONObject();
		message.put("_class", className);
		message.put("_method", functionName);
		message.put("_arg1", arg1);
		if(type==LOG_ERROR){
			defaultLogger.error(message);
		}
		else{
			defaultLogger.info(message);
		}
	}
	public static void appendFunctionLog(int type, String className, String functionName, String arg1, String arg2) throws JSONException{
		JSONObject message = new JSONObject();
		message.put("_class", className);
		message.put("_method", functionName);
		message.put("_arg1", arg1);
		message.put("_arg2", arg2);
		if(type==LOG_ERROR){
			defaultLogger.error(message);
		}
		else{
			defaultLogger.info(message);
		}
	}
	public static void appendFunctionLog(int type, String className, String functionName, String arg1, String arg2, String arg3) throws JSONException{
		JSONObject message = new JSONObject();
		message.put("_class", className);
		message.put("_method", functionName);
		message.put("_arg1", arg1);
		message.put("_arg2", arg2);
		message.put("_arg3", arg3);
		defaultLogger.info(message);
	}

	public static LogService getInstance() {

		return instance;
	}

	public static Logger createLogger(String topic, Writer writer) {
		Logger additionalLogger = Logger.getLogger(topic);
		PatternLayout layout = new PatternLayout(
				PatternLayout.TTCC_CONVERSION_PATTERN);
		WriterAppender appender = new WriterAppender(layout, writer);
		additionalLogger.addAppender(appender);
		return additionalLogger;
	}

	/*
	 * public static Logger getLogger(String topic){
	 * 
	 * Logger logger = Logger.getLogger(topic); return logger; } public static
	 * Logger getLogger(){
	 * 
	 * return defaultLogger; }
	 */
	public static void info(String tag, String className, String methodName,
			String description) {
		defaultLogger.info(tag + ":[" + className + ":" + methodName + "]:"
				+ description);
	}

	public static void info(String tag, String className, String methodName,
			String description, Throwable t) {
		defaultLogger.info(tag + ":[" + className + ":" + methodName + "]:"
				+ description, t);

	}

	public static void debug(String tag, String className, String methodName,
			String description) {
		defaultLogger.debug(tag + ":[" + className + ":" + methodName + "]:"
				+ description);
		System.out.println(tag + ":[" + className + ":" + methodName + "]:"
				+ description);
	}

	public static void debug(String tag, String className, String methodName,
			String description, Throwable t) {
		defaultLogger.debug(tag + ":[" + className + ":" + methodName + "]:"
				+ description, t);

	}

	public static void error(String tag, String className, String methodName,
			String description) {
		defaultLogger.error(tag + ":[" + className + ":" + methodName + "]:"
				+ description);

	}

	public static void error(String tag, String className, String methodName,
			String description, Throwable t) {
		defaultLogger.error("[" + className + ":" + methodName + "]:"
				+ description, t);

	}
}
