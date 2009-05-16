package com.mui.launch;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;

import org.codehaus.classworlds.ClassRealm;
import org.codehaus.classworlds.ClassWorld;
import org.codehaus.classworlds.ConfigurationException;
import org.codehaus.classworlds.DuplicateRealmException;
import org.codehaus.classworlds.NoSuchRealmException;

import com.mui.logger.MavenLogger;

public class GuiLauncher {

	protected String mainClassName;
	protected String mainRealmName;
	protected ClassWorld world;
	private int exitCode;
	protected ClassLoader systemClassLoader;

	public static void main(String[] args) {
		try {
			int exitCode = mainWithExitCode(args);
			//System.exit(exitCode);
		} catch (Exception e) {
			e.printStackTrace();
			//System.exit(100);
		}
	}

	public static int mainWithExitCode(String args[]) throws Exception {
		GuiLauncher guiLauncher = new GuiLauncher();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		guiLauncher.setSystemClassLoader(cl);

		guiLauncher.configure();
		try {
			guiLauncher.launch(args);
		} catch (InvocationTargetException e) {
			ClassRealm realm = guiLauncher.getWorld().getRealm(
					guiLauncher.getMainRealmName());
			java.net.URL constituents[] = realm.getConstituents();
			MavenLogger.info("---------------------------------------------------");
			for (int i = 0; i < constituents.length; i++)
				MavenLogger.info("constituent[" + i + "]: " + constituents[i]);

			MavenLogger.info("---------------------------------------------------");
			Throwable t = e.getTargetException();
			if (t instanceof Exception)
				throw (Exception) t;
			if (t instanceof Error)
				throw (Error) t;
			else
				throw e;
		}
		return guiLauncher.getExitCode();
	}

	public void launch(String args[]) throws ClassNotFoundException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, NoSuchRealmException {
		try {
			launchEnhanced(args);
			return;
		} catch (NoSuchMethodException e) {
			launchStandard(args);
		}
	}

	protected void launchEnhanced(String args[]) throws ClassNotFoundException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, NoSuchRealmException {
		ClassRealm mainRealm = getMainRealm();
		Class mainClass = getMainClass();
		Method mainMethod = getEnhancedMainMethod();
		ClassLoader cl = mainRealm.getClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		exitCode = MavenGui.main(args, getWorld());
		/*Object ret = mainMethod.invoke(mainClass, new Object[] { args,
				getWorld() });
		if (ret instanceof Integer)
			exitCode = ((Integer) ret).intValue();*/
	}

	protected void launchStandard(String args[]) throws ClassNotFoundException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, NoSuchRealmException {
		ClassRealm mainRealm = getMainRealm();
		Class mainClass = getMainClass();
		Method mainMethod = getMainMethod();
		Thread.currentThread()
				.setContextClassLoader(mainRealm.getClassLoader());
		//Object ret = mainMethod.invoke(mainClass, new Object[] { args });
		exitCode = MavenGui.main(args, getWorld());
		//if (ret instanceof Integer)
			//exitCode = ((Integer) ret).intValue();
	}

	public void configure() throws MalformedURLException,
			DuplicateRealmException, NoSuchRealmException,
			FileNotFoundException, ConfigurationException {
		GuiConfigurator configurator = new GuiConfigurator(this);
		configurator.configure();
	}

	public void setAppMain(String mainClassName, String mainRealmName) {
		this.mainClassName = mainClassName;
		this.mainRealmName = mainRealmName;
	}

	public Class getMainClass() throws ClassNotFoundException,
			NoSuchRealmException {
		return getMainRealm().loadClass(getMainClassName());
	}

	public ClassRealm getMainRealm() throws NoSuchRealmException {
		return getWorld().getRealm(getMainRealmName());
	}

	protected Method getEnhancedMainMethod() throws ClassNotFoundException,
			NoSuchMethodException, NoSuchRealmException {
		Method methods[] = getMainClass().getMethods();
		Class cwClass = getMainRealm().loadClass(
				(org.codehaus.classworlds.ClassWorld.class).getName());
		Method m = getMainClass().getMethod("main",
				new Class[] { java.lang.String[].class, cwClass });
		int modifiers = m.getModifiers();
		if (Modifier.isStatic(modifiers)
				&& Modifier.isPublic(modifiers)
				&& (m.getReturnType() == Integer.TYPE || m.getReturnType() == Void.TYPE))
			return m;
		else
			throw new NoSuchMethodException(
					"public static void main(String[] args, ClassWorld world)");
	}

	protected Method getMainMethod() throws ClassNotFoundException,
			NoSuchMethodException, NoSuchRealmException {
		Method m = getMainClass().getMethod("main",
				new Class[] { java.lang.String[].class });
		int modifiers = m.getModifiers();
		if (Modifier.isStatic(modifiers)
				&& Modifier.isPublic(modifiers)
				&& (m.getReturnType() == Integer.TYPE || m.getReturnType() == Void.TYPE))
			return m;
		else
			throw new NoSuchMethodException(
					"public static void main(String[] args) in "
							+ getMainClass());
	}

	/* ******** Getter Setters *************** */

	public ClassLoader getSystemClassLoader() {
		return systemClassLoader;
	}

	public void setSystemClassLoader(ClassLoader systemClassLoader) {
		this.systemClassLoader = systemClassLoader;
	}

	public String getMainClassName() {
		return mainClassName;
	}

	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}

	public String getMainRealmName() {
		return mainRealmName;
	}

	public void setMainRealmName(String mainRealmName) {
		this.mainRealmName = mainRealmName;
	}

	public ClassWorld getWorld() {
		return world;
	}

	public void setWorld(ClassWorld world) {
		this.world = world;
	}

	public int getExitCode() {
		return exitCode;
	}

	public void setExitCode(int exitCode) {
		this.exitCode = exitCode;
	}

}
