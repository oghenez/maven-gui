/**
 * GUI tool for Maven
 * 
 * File		: com.mui.boot.BootMavenGui.java
 * Type		: com.mui.boot.BootMavenGui
 * 
 * Date		: Apr 9, 2009	12:04:02 PM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.boot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mui.BootLoaderException;
import com.mui.ContextLoadException;
import com.mui.MavenCommonContext;
import com.mui.MavenGUIContext;
import com.mui.MavenGUILauncher;
import com.mui.MavenGuiConstants;
import com.mui.env.MavenEnvironmentConstants;
import com.mui.env.MavenEnvironmentVariables;
import com.mui.env.UnknownVariableException;
import com.mui.view.TestFrame;

/**
 * @author sabuj.das
 * 
 */
public class BootMavenGui implements MavenEnvironmentConstants,
		MavenGuiConstants {

	public static String MAVEN_HOME;
	public static String JAVA_HOME;

	private static MavenCommonContext commonContext = MavenCommonContext.getInstance();
	private static MavenGUIContext mavenGUIContext = MavenGUIContext.getInstance();

	public static void main(String[] args) {
		// TODO: Show splash
		try {
			boot();
		} catch (UnknownVariableException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error !!!", JOptionPane.ERROR_MESSAGE);
		} catch (ContextLoadException e) {
			e.printStackTrace();
		} catch (BootLoaderException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void boot() throws UnknownVariableException,
			ContextLoadException, BootLoaderException, IOException {
		loadInitialContext();
		commonContext.mavenEnvironmentVariables = loadEnvironmentVariavles();
		start();
	}

	private static MavenEnvironmentVariables loadEnvironmentVariavles()
			throws UnknownVariableException, FileNotFoundException, IOException {
		Map<String, String> sysEnvMap = System.getenv();
		MavenEnvironmentVariables initialVars = new MavenEnvironmentVariables();
		Properties properties = new Properties();
		File propFile = new File(PROPERTIES_FILE_NAME);
		if (propFile.exists()) {
			properties.load(new FileInputStream(propFile));
			MAVEN_HOME = properties.getProperty("MAVEN_HOME");
			JAVA_HOME = properties.getProperty("JAVA_HOME");
		}

		if (MAVEN_HOME != null && MAVEN_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable(MAVEN_HOME_ENV_VAR_NAME,
					MAVEN_HOME, true);
		} else {
			MAVEN_HOME = sysEnvMap.get(MAVEN_HOME_ENV_VAR_NAME);
			if (MAVEN_HOME != null && MAVEN_HOME.trim().length() > 0) {
				initialVars.addEnvironmentVariable(MAVEN_HOME_ENV_VAR_NAME,
						MAVEN_HOME, true);
			} else {
				MAVEN_HOME = DEFAULT_MAVEN_HOME;
				File home = new File(DEFAULT_MAVEN_HOME);
				File m2Home = new File(home, ".m2");
				if(!m2Home.exists()){
					m2Home.mkdir();
				}
				File confDir = new File(DEFAULT_CONF_DIR);
				if(!confDir.exists()){
					confDir.mkdir();
				}
				File libDir = new File(DEFAULT_LIB_DIR);
				if(!libDir.exists()){
					libDir.mkdir();
				}
			}
		}

		if (JAVA_HOME != null && JAVA_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable(JAVA_HOME_ENV_VAR_NAME,
					JAVA_HOME, true);
		} else {
			JAVA_HOME = sysEnvMap.get(JAVA_HOME_ENV_VAR_NAME);
			if (JAVA_HOME != null && JAVA_HOME.trim().length() > 0) {
				initialVars.addEnvironmentVariable(JAVA_HOME_ENV_VAR_NAME,
						JAVA_HOME, true);
			} else {
				throw new UnknownVariableException("JAVA_HOME is not set.");
			}
		}
		System.setProperty(JAVA_HOME_SYS_PROP_NAME, JAVA_HOME);
		System.setProperty(USER_HOME_SYS_PROP_NAME, MAVEN_HOME);
		return initialVars;
	}

	private static void loadInitialContext() throws ContextLoadException {
		File contextFile = new File(DEFAULT_CONTEXT_DIR + "/" + CONTEXT_FILE_NAME);
		if (contextFile.exists()) {
			ObjectInputStream objectInputStream = null;
			try {
				objectInputStream = new ObjectInputStream(new FileInputStream(
						contextFile));
				MavenGUIContext ctx = (MavenGUIContext) objectInputStream
						.readObject();
				if (ctx != null) {
					mavenGUIContext.setEnvironmentVariables(ctx
							.getEnvironmentVariables());
					mavenGUIContext.setFrameLocation(ctx.getFrameLocation());
					mavenGUIContext.setFrameSize(ctx.getFrameSize());
					mavenGUIContext.setMavenHomeDir(ctx.getMavenHomeDir());
					mavenGUIContext.setProjectBaseDirPath(ctx.getProjectBaseDirPath());
					mavenGUIContext.setSettingsFileDir(ctx.getSettingsFileDir());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (objectInputStream != null) {
					try {
						objectInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			File contextDir = new File(DEFAULT_CONTEXT_DIR);
			if (!contextDir.exists()) {
				contextDir.mkdir();
			}
			ObjectOutputStream os = null;
			try {
				contextFile.createNewFile();
				os = new ObjectOutputStream(new FileOutputStream(contextFile));
				os.writeObject(mavenGUIContext);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static void start() throws BootLoaderException {
		//MavenGUILauncher.main(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			TestFrame frame = new TestFrame();
			frame.setVisible(true);
		}catch(Exception e){
			throw new BootLoaderException("Cannot open GUI.");
		}
	}

}
