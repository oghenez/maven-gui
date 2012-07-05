/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gs.xaven.common.model;

/**
 *
 * @author Sabuj Das | sabuj.das@gmail.com
 */
public enum ProjectType {

	POM("pom", "pom"), 
	JAR("jar" , "jar"),
	WAR("war", "war");
	
	private final String type;
	private final String description;

	private ProjectType(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

}
