package com.mui.integration.impl;



import com.mui.integration.MavenIntegration;
import com.mui.logger.MavenLogger;

public class MavenIntegrationImpl implements MavenIntegration {

	public void execuiteCommand(String baseDir, String commandLine, MavenLogger logger){
		logger.logInfo("Invoking : " + commandLine);
		logger.logInfo("Base Dir : " + baseDir);
		logger.info("--------------------------------------------------------------------------------");
		
		
	}
}
