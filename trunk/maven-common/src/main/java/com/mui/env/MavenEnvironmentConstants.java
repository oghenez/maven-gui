/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mui.env;

/**
 *
 * @author sabuj.das
 */
public interface MavenEnvironmentConstants {
	
	String DEFAULT_MAVEN_HOME = "home";
	String DEFAULT_CONF_DIR = "home/conf";
	String DEFAULT_LIB_DIR = "home/lib";
	String DEFAULT_PROPERTIES_DIR = "setup";
	String DEFAULT_CONTEXT_DIR = "context";
	String DEFAULT_M2_DIR = "m2_home";
	String CONTEXT_FILE_NAME = "maven_context.ctx";
	String PROPERTIES_FILE_NAME = "maven_env.properties";
	

    String MAVEN_HOME_ENV_VAR_NAME = "MAVEN_HOME";
    String JAVA_HOME_ENV_VAR_NAME = "JAVA_HOME";
    String USER_HOME_ENV_VAR_NAME = "USER_HOME";
    String BASE_DIR_ENV_VAR_NAME = "USER_DIR";
    String M2_HOME_ENV_VAR_NAME = "M2_HOME";
    
    String MAVEN_HOME_SYS_PROP_NAME = "maven.home";
	String USER_HOME_SYS_PROP_NAME = "user.home";
	String JAVA_HOME_SYS_PROP_NAME = "java.home";
	String JRE_HOME_SYS_PROP_NAME = "jre.home";
	String M2_HOME_SYS_PROP_NAME = "m2.home";

	
}
