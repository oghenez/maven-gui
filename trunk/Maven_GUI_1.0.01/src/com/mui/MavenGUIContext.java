/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.util.MavenGUIContext.java
 * Date		:	Dec 9, 2008 __ 1:12:51 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.Serializable;

import javax.swing.UIManager;

import com.mui.env.MavenEnvironmentVariables;
import com.mui.gui.io.MavenOutputDevice;
import com.mui.gui.io.impl.JTextAreaWriter;


/**
 * @author sabuj.das
 *
 */
public class MavenGUIContext implements Serializable{
    /**
	 *  Generated serialVersionUID
	 */
	private static final long serialVersionUID = 4592158057696732308L;

	/*  Static Instance   */
	private static MavenGUIContext instance;
	
	public static MavenGUIContext getInstance(){
		if(instance == null){
			instance = new MavenGUIContext();
		}
		return instance;
	}
	
	/* ******************************** */
	
	private String lookNfeelClassName = UIManager.getSystemLookAndFeelClassName();

    private MavenEnvironmentVariables environmentVariables;
    private File settingsFileDir;
    private File mavenHomeDir;
    private MavenOutputDevice outputDevice;
    private JTextAreaWriter textAreaWriter;
    private String projectBaseDirPath;
    
    // Frame properties
    
    private Point frameLocation;
    private Dimension frameSize;
    
	/* ******************************** */
	
	public String getLookNfeelClassName() {
		return lookNfeelClassName;
	}

	public void setLookNfeelClassName(String lookNfeelClassName) {
		this.lookNfeelClassName = lookNfeelClassName;
	}

    public MavenEnvironmentVariables getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(MavenEnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

	public File getSettingsFileDir() {
		return settingsFileDir;
	}

	public void setSettingsFileDir(File settingsFileDir) {
		this.settingsFileDir = settingsFileDir;
	}

	public File getMavenHomeDir() {
		return mavenHomeDir;
	}

	public void setMavenHomeDir(File mavenHomeDir) {
		this.mavenHomeDir = mavenHomeDir;
	}

	public MavenOutputDevice getOutputDevice() {
		return outputDevice;
	}

	public void setOutputDevice(MavenOutputDevice outputDevice) {
		this.outputDevice = outputDevice;
	}

	public JTextAreaWriter getTextAreaWriter() {
		return textAreaWriter;
	}

	public void setTextAreaWriter(JTextAreaWriter textAreaWriter) {
		this.textAreaWriter = textAreaWriter;
	}

	public String getProjectBaseDirPath() {
		return projectBaseDirPath;
	}

	public void setProjectBaseDirPath(String projectBaseDirPath) {
		this.projectBaseDirPath = projectBaseDirPath;
	}

	public Point getFrameLocation() {
		return frameLocation;
	}

	public void setFrameLocation(Point frameLocation) {
		this.frameLocation = frameLocation;
	}

	public Dimension getFrameSize() {
		return frameSize;
	}

	public void setFrameSize(Dimension frameSize) {
		this.frameSize = frameSize;
	}
	
	
}
