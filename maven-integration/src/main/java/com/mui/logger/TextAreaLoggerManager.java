package com.mui.logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.codehaus.plexus.logging.AbstractLoggerManager;
import org.codehaus.plexus.logging.Logger;
import org.codehaus.plexus.logging.LoggerManager;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;

public class TextAreaLoggerManager extends AbstractLoggerManager implements
		LoggerManager, Initializable {

	/**
	 * Message of this level or higher will be logged.
	 * 
	 * This field is set by the plexus container thus the name is 'threshold'.
	 * The field currentThreshold contains the current setting of the threshold.
	 */
	private String threshold = "info";

	private int currentThreshold;

	private Map loggers;

	/** The number of active loggers in use. */
	private int loggerCount;

	private boolean bootTimeLogger = false;

	public TextAreaLoggerManager() {
		// TODO Auto-generated constructor stub
	}

	public TextAreaLoggerManager(String threshold) {
		this.threshold = threshold;

		bootTimeLogger = true;

		initialize();
	}

	public void setThreshold(int currentThreshold) {
		this.currentThreshold = currentThreshold;
	}

	public void setThresholds(int currentThreshold) {
		this.currentThreshold = currentThreshold;

		for (Iterator logs = loggers.values().iterator(); logs.hasNext();) {
			TextAreaLogger logger = (TextAreaLogger) logs.next();
			logger.setThreshold(currentThreshold);
		}
	}

	/**
	 * @return Returns the threshold.
	 */
	public int getThreshold() {
		return currentThreshold;
	}

	// new stuff

	public void setThreshold(String role, String roleHint, int threshold) {
		TextAreaLogger logger;
		String name;

		name = toMapKey(role, roleHint);
		logger = (TextAreaLogger) loggers.get(name);

		if (logger == null) {
			debug("Trying to set the threshold of a unknown logger '" + name
					+ "'.");
			return; // nothing to do
		}

		logger.setThreshold(threshold);
	}

	public int getThreshold(String role, String roleHint) {
		TextAreaLogger logger;
		String name;

		name = toMapKey(role, roleHint);
		logger = (TextAreaLogger) loggers.get(name);

		if (logger == null) {
			debug("Trying to get the threshold of a unknown logger '" + name
					+ "'.");
			return Logger.LEVEL_DEBUG; // does not return null because that
										// could create a NPE
		}

		return logger.getThreshold();
	}

	public Logger createLogger(int threshold, String name) {
		return new TextAreaLogger(threshold, name);
	}

	public Logger getLoggerForComponent(String role, String roleHint) {
		Logger logger;
		String name;

		name = toMapKey(role, roleHint);
		logger = (Logger) loggers.get(name);

		if (logger != null)
			return logger;

		debug("Creating logger '" + name + "' " + this.hashCode() + ".");
		logger = createLogger(getThreshold(), name);
		loggers.put(name, logger);

		return logger;
	}

	public void returnComponentLogger(String role, String roleHint) {
		Object obj;
		String name;

		name = toMapKey(role, roleHint);
		obj = loggers.remove(name);

		if (obj == null) {
			debug("There was no such logger '" + name + "' " + this.hashCode()
					+ ".");
		} else {
			debug("Removed logger '" + name + "' " + this.hashCode() + ".");
		}
	}

	public int getActiveLoggerCount() {
		return loggers.size();
	}

	public void initialize() {
		debug("Initializing ConsoleLoggerManager: " + this.hashCode() + ".");
		// if ( !bootTimeLogger )
		// new Throwable().printStackTrace(System.err);
		currentThreshold = parseThreshold(threshold);

		if (currentThreshold == -1) {
			debug("Could not parse the threshold level: '" + threshold
					+ "', setting to debug.");
			currentThreshold = Logger.LEVEL_DEBUG;
		}

		loggers = new HashMap();
	}

	private int parseThreshold(String text) {
		text = text.trim().toLowerCase(Locale.ENGLISH);

		if (text.equals("debug")) {
			return TextAreaLogger.LEVEL_DEBUG;
		} else if (text.equals("info")) {
			return TextAreaLogger.LEVEL_INFO;
		} else if (text.equals("warn")) {
			return TextAreaLogger.LEVEL_WARN;
		} else if (text.equals("error")) {
			return TextAreaLogger.LEVEL_ERROR;
		} else if (text.equals("fatal")) {
			return TextAreaLogger.LEVEL_FATAL;
		}

		return -1;
	}

	private String decodeLogLevel(int logLevel) {
		switch (logLevel) {
		case TextAreaLogger.LEVEL_DEBUG:
			return "debug";
		case TextAreaLogger.LEVEL_INFO:
			return "info";
		case TextAreaLogger.LEVEL_WARN:
			return "warn";
		case TextAreaLogger.LEVEL_ERROR:
			return "error";
		case TextAreaLogger.LEVEL_FATAL:
			return "fatal";
		case TextAreaLogger.LEVEL_DISABLED:
			return "disabled";
		default:
			return "unknown";
		}
	}

	private void debug(String msg) {
		// if ( !bootTimeLogger )
		// System.out.println( "[Console] " + msg );
	}

}
