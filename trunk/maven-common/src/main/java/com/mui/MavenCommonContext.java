package com.mui;


import java.util.Properties;

import com.mui.env.MavenEnvironmentVariables;
import com.mui.logger.MavenProgressMonitor;
import com.mui.logger.TextAreaLogAppender;




public class MavenCommonContext {

	
	public TextAreaLogAppender textAreaLogAppender;
	public MavenProgressMonitor mavenProgressMonitor;
	public MavenEnvironmentVariables mavenEnvironmentVariables;
	
	
	/* --------------------  Instance  ---------------------------------------------- */	
	private static MavenCommonContext instance;
	
	private MavenCommonContext(){}
	
	public static MavenCommonContext getInstance() {
		if(instance == null){
			instance = new MavenCommonContext();
		}
		return instance;
	}
	
	
}
