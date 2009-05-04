package com.mui.integration.impl;

import com.mui.integration.MavenIntegration;
import com.mui.logger.MavenLogger;

public class MavenIntegrationImpl implements MavenIntegration {

	public void execuiteCommand(String baseDir, String commandLine, MavenLogger logger){
		logger.logInfo("Base Dir : " + baseDir);
		logger.logInfo("Command Line : " + commandLine);
	}
}
