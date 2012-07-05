/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gs.xaven.common.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sabuj Das | sabuj.das@gmail.com
 */
public class Project {

	private Project parent;
	private Set<Project> modules;
	
	private String artifactId;
	private String groupId;
	private String version;
	private ProjectType projectType;

	public Project() {
		modules = new HashSet<Project> ();
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Set<Project> getModules() {
		return modules;
	}

	public void setModules(Set<Project> modules) {
		this.modules = modules;
	}

	public Project getParent() {
		return parent;
	}

	public void setParent(Project parent) {
		this.parent = parent;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
