package com.mui.logger;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MavenLogger{
	
	public static Logger logger = Logger.getLogger("Logger");
    private static boolean init = false;
	

    public static void init(Appender appender, Level l) {
        if (init != true) {
            logger.addAppender(appender);
            logger.setLevel(l);
        }
        init = true;
    }

    public static void logWarn(final String s) {
        logger.warn(s);
    }

    public static void logError(final String s) {
        logger.error(s);
    }

    public static void logError(final Throwable ex) {
        logger.fatal(new String(), ex);
    }

    public static void logTrace(final String s) {
        logger.trace(s);
    }

    public static void logInfo(final String s) {
        logger.info(s);
    }

	public static void debug(String message, Throwable t) {
		logger.debug(message, t);
	}

	public static void error(String message, Throwable t) {
		logger.error(message, t);
	}

	public static void fatalError(String message, Throwable t) {
		logger.fatal(message, t);
	}

	public static void info(String message, Throwable t) {
		logger.info(message, t);
	}

	public static void warn(String message, Throwable t) {
		logger.warn(message, t);
	}

	public static void info(String message) {
		logger.info(message);
	}
}
