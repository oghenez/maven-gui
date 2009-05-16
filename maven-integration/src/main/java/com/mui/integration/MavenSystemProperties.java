package com.mui.integration;

import java.util.Properties;

public class MavenSystemProperties {

	
	public static final String MAVEN_HOME = "maven.home";
	public static final String USER_HOME = "user.home";
	
	
	private Properties sysProperties;
	
	public MavenSystemProperties() {
		sysProperties = new Properties();
	}
	
}
