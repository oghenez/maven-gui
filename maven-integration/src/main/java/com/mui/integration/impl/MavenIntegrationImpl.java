package com.mui.integration.impl;

import org.apache.maven.cli.MavenCli;
import org.codehaus.classworlds.ClassWorld;

import com.mui.integration.MavenIntegration;
import com.mui.logger.MavenLogger;

public class MavenIntegrationImpl implements MavenIntegration {

	public void execuiteCommand(String baseDir, String commandLine, MavenLogger logger){
		logger.logInfo("Invoking : " + commandLine);
		logger.logInfo("Base Dir : " + baseDir);
		logger.info("--------------------------------------------------------------------------------");
		
		ClassWorld world = new ClassWorld();
		
		MavenCli cli = new MavenCli();
		cli.main(new String[]{"install"}, world);
	}
}
