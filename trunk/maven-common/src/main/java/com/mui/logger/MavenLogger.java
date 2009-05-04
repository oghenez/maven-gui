package com.mui.logger;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.plexus.logging.AbstractLogger;

public class MavenLogger extends AbstractLogger{
	
	public static Logger logger = Logger.getLogger("Logger");
    private static boolean init = false;
	
    public MavenLogger(int threshold, String name) {
		super(threshold, name);
	}

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

	public void debug(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	public void error(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	public void fatalError(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	public org.codehaus.plexus.logging.Logger getChildLogger(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void info(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	public void warn(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}
}
