package com.mui.integration;

import com.mui.logger.MavenLogger;

public interface MavenIntegration {

	public void execuiteCommand(String baseDir, String commandLine, MavenLogger logger);
	
}
