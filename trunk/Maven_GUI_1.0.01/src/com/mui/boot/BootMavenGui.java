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

import com.mui.BootLoaderException;
import com.mui.ContextLoadException;
import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;
import com.mui.MavenGuiLauncher;
import com.mui.env.MavenEnvironmentConstants;
import com.mui.env.MavenEnvironmentVariables;
import com.mui.env.UnknownVariableException;

/**
 * @author sabuj.das
 * 
 */
public class BootMavenGui {
	
	public static String MAVEN_HOME;
	public static String JAVA_HOME;
	public static String USER_HOME;
	public static String USER_DIR;
	public static String M2_HOME;
	
	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	public static void main(String[] args) {
		
		try {
			boot();
		} catch (UnknownVariableException e) {
			e.printStackTrace();
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
		
		loadEnvironmentVariavles();
		
		start();
	}

	private static void loadEnvironmentVariavles()
			throws UnknownVariableException, FileNotFoundException, IOException {
		Map<String, String> sysEnvMap = System.getenv();
		MavenEnvironmentVariables initialVars = new MavenEnvironmentVariables();
		// TODO: need to do exception handling 
		Properties properties = new Properties();
		properties.load(new FileInputStream(MavenGuiConstants.PROPERTIES_FILE_NAME
                + "maven_env.properties"));
				//new File(MavenGuiConstants.PROPERTIES_FILE_NAME + "maven_env.properties")));
		
		MAVEN_HOME = properties.getProperty("MAVEN_HOME");
		JAVA_HOME = properties.getProperty("JAVA_HOME");
		USER_HOME = properties.getProperty("USER_HOME");
		USER_DIR = properties.getProperty("USER_DIR");
		M2_HOME = properties.getProperty("M2_HOME");

		if (MAVEN_HOME != null && MAVEN_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable(MavenEnvironmentConstants.MAVEN_HOME_VAR_NAME, MAVEN_HOME, true);
		} else {
			MAVEN_HOME = sysEnvMap
					.get(MavenEnvironmentConstants.MAVEN_HOME_VAR_NAME);
			if (MAVEN_HOME != null && MAVEN_HOME.trim().length() > 0) {
				initialVars.addEnvironmentVariable(MavenEnvironmentConstants.MAVEN_HOME_VAR_NAME, MAVEN_HOME, true);
			}else{
				throw new UnknownVariableException("MAVEN_HOME is not set.");
			}
		}
		
		if (JAVA_HOME != null && JAVA_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable(MavenEnvironmentConstants.JAVA_HOME_VAR_NAME, JAVA_HOME, true);
		} else {
			JAVA_HOME = sysEnvMap
					.get(MavenEnvironmentConstants.JAVA_HOME_VAR_NAME);
			if (JAVA_HOME != null && JAVA_HOME.trim().length() > 0) {
				initialVars.addEnvironmentVariable(MavenEnvironmentConstants.JAVA_HOME_VAR_NAME, JAVA_HOME, true);
			}else{
				throw new UnknownVariableException("JAVA_HOME is not set.");
			}
		}
		
		if (USER_HOME != null && USER_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable(MavenEnvironmentConstants.USER_HOME_VAR_NAME, USER_HOME, true);
		} else {
			USER_HOME = sysEnvMap
					.get(MavenEnvironmentConstants.USER_HOME_VAR_NAME);
			if (USER_HOME != null && USER_HOME.trim().length() > 0) {
				initialVars.addEnvironmentVariable(MavenEnvironmentConstants.USER_HOME_VAR_NAME, USER_HOME, true);
			}else{
				throw new UnknownVariableException("USER_HOME is not set.");
			}
		}
		
		if (USER_DIR != null && USER_DIR.trim().length() > 0) {
			initialVars.addEnvironmentVariable(MavenEnvironmentConstants.BASE_DIR_VAR_NAME, USER_DIR, true);
		} else {
			initialVars.addEnvironmentVariable(MavenEnvironmentConstants.BASE_DIR_VAR_NAME, ".", true);
		}
		if (M2_HOME != null && M2_HOME.trim().length() > 0) {
			initialVars.addEnvironmentVariable("M2_HOME", M2_HOME, true);
		} else {
			initialVars.addEnvironmentVariable("M2_HOME", ".", true);
		}
	}

	private static void loadInitialContext() throws ContextLoadException{
		File contextFile = new File(MavenGuiConstants.CONTEXT_FILE_NAME +
                "maven_context.ctx");
		if(contextFile.exists()){
			ObjectInputStream objectInputStream = null;
			try{
				objectInputStream = new ObjectInputStream(
						new FileInputStream(contextFile)
					);
				MavenGUIContext ctx = (MavenGUIContext) objectInputStream.readObject();
				if(ctx != null){
					context.setEnvironmentVariables(ctx.getEnvironmentVariables());
					context.setFrameLocation(ctx.getFrameLocation());
					context.setFrameSize(ctx.getFrameSize());
					//context.setLookNfeelClassName(ctx.getLookNfeelClassName());
					context.setMavenHomeDir(ctx.getMavenHomeDir());
					context.setOutputDevice(ctx.getOutputDevice());
					context.setProjectBaseDirPath(ctx.getProjectBaseDirPath());
					context.setSettingsFileDir(ctx.getSettingsFileDir());
					context.setTextAreaWriter(ctx.getTextAreaWriter());
				}
			}catch(IOException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally{
				if(objectInputStream != null){
					try {
						objectInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}else{
			ObjectOutputStream os = null;
			try {
				contextFile.createNewFile();
				os = new ObjectOutputStream(new FileOutputStream(contextFile));
				os.writeObject(context);
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				if(os != null){
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
		MavenGuiLauncher.main(null);
		/*classworlds.conf
		maven.home
		org.codehaus.classworlds.Launcher %MAVEN_CMD_LINE_ARGS%
		*/
		
		//Launcher.main(null);
		
		/*MavenCli cli = new MavenCli();
		cli.main(new String[]{"-e"}, new ClassWorld());*/
	}

}
