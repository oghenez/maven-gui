package com.mui.logger;

import org.apache.log4j.Level;
import org.codehaus.plexus.logging.AbstractLogger;
import org.codehaus.plexus.logging.Logger;

import com.mui.MavenCommonContext;


public class TextAreaLogger extends AbstractLogger {

	public static final String LOGGER_NAME = "TextAreaLogger::AbstractLogger";

	private static MavenCommonContext context = MavenCommonContext.getInstance();
	
	public TextAreaLogger(int threshold, String name) {
		super(threshold, name);
		MavenLogger.init(context.textAreaLogAppender, Level.DEBUG);
	}

	public void debug(String message, Throwable throwable) {
		if ( isDebugEnabled() )
        {
            MavenLogger.debug(message, throwable);
            if ( null != throwable )
            {
                throwable.printStackTrace( System.out );
            }
        }
	}

	public void error(String message, Throwable throwable) {
		if ( isErrorEnabled() )
        {
			MavenLogger.error(message, throwable);
            if ( null != throwable )
            {
                throwable.printStackTrace( System.out );
            }
        }
	}

	public void fatalError(String message, Throwable throwable) {
		if ( isFatalErrorEnabled() )
        {
            MavenLogger.fatalError(message, throwable);
            if ( null != throwable )
            {
                throwable.printStackTrace( System.out );
            }
        }
	}

	public Logger getChildLogger(String arg0) {
		return this;
	}

	public void info(String message, Throwable throwable) {
		if ( isInfoEnabled() )
        {
            MavenLogger.info(message, throwable);
            if ( null != throwable )
            {
                throwable.printStackTrace( System.out );
            }
        }
	}

	public void warn(String message, Throwable throwable) {
		if ( isWarnEnabled() )
        {
            MavenLogger.warn(message, throwable);
            if ( null != throwable )
            {
                throwable.printStackTrace( System.out );
            }
        }
	}

}
