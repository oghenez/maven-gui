package com.mui.launch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.classworlds.ClassRealm;
import org.codehaus.classworlds.ClassWorld;
import org.codehaus.classworlds.ConfigurationException;
import org.codehaus.classworlds.DuplicateRealmException;
import org.codehaus.classworlds.NoSuchRealmException;

public class GuiConfigurator {

	public static final String MAIN_CLASS_NAME = "org.apache.maven.cli.MavenCli";
	public static final String MAIN_REALM_NAME = "plexus.core";
	public static final String MAVEN_HOME = "c:\\conf";

	private GuiLauncher guiLauncher;
	private ClassWorld world;
	private Map configuredRealms;

	public GuiConfigurator(GuiLauncher guiLauncher) {
		this.guiLauncher = guiLauncher;
		configuredRealms = new HashMap();
	}

	public GuiConfigurator(ClassWorld world) {
		setClassWorld(world);
	}

	public void setClassWorld(ClassWorld world) {
		this.world = world;
		configuredRealms = new HashMap();
	}

	public void configure() throws MalformedURLException,
			ConfigurationException, DuplicateRealmException,
			NoSuchRealmException, FileNotFoundException {
		ClassRealm curRealm = null;
		ClassLoader foreignClassLoader = null;

		if (world == null)
			world = new ClassWorld();

		if (guiLauncher != null) {
			foreignClassLoader = guiLauncher.getSystemClassLoader();
			guiLauncher.setAppMain(MAIN_CLASS_NAME, MAIN_REALM_NAME);
		}
		System.setProperty("maven.home", MAVEN_HOME);

		curRealm = world.newRealm(MAIN_REALM_NAME, foreignClassLoader);
		configuredRealms.put(MAIN_REALM_NAME, curRealm);
		String line = "c:/conf/lib/*.jar";
		String constituent = "c:/conf/lib/*.jar";
		if (constituent.indexOf("*") >= 0) {
			loadGlob(constituent, curRealm);
		} else {
			File file = new File(constituent);
			if (file.exists())
				curRealm.addConstituent(file.toURL());
			else
				try {
					curRealm.addConstituent(new URL(constituent));
				} catch (MalformedURLException e) {
					throw new FileNotFoundException(constituent);
				}
		}
		
		associateRealms();
        if(guiLauncher != null)
            guiLauncher.setWorld(world);
	}

	protected void associateRealms()
    {
        List sortRealmNames = new ArrayList(configuredRealms.keySet());
        Comparator comparator = new Comparator() {

            public int compare(Object o1, Object o2)
            {
                String g1 = (String)o1;
                String g2 = (String)o2;
                return g1.compareTo(g2);
            }

        };
        Collections.sort(sortRealmNames, comparator);
        Iterator i = sortRealmNames.iterator();
        do
        {
            if(!i.hasNext())
                break;
            String realmName = (String)i.next();
            int j = realmName.lastIndexOf('.');
            if(j > 0)
            {
                String parentRealmName = realmName.substring(0, j);
                ClassRealm parentRealm = (ClassRealm)configuredRealms.get(parentRealmName);
                if(parentRealm != null)
                {
                    ClassRealm realm = (ClassRealm)configuredRealms.get(realmName);
                    realm.setParent(parentRealm);
                }
            }
        } while(true);
    }
	protected void loadGlob(String line, ClassRealm realm)
			throws MalformedURLException, FileNotFoundException {
		loadGlob(line, realm, false);
	}

	protected void loadGlob(String line, ClassRealm realm, boolean optionally)
			throws MalformedURLException, FileNotFoundException {
		File globFile = new File(line);
		File dir = globFile.getParentFile();
		if (!dir.exists())
			if (optionally)
				return;
			else
				throw new FileNotFoundException(dir.toString());
		String localName = globFile.getName();
		int starLoc = localName.indexOf("*");
		final String prefix = localName.substring(0, starLoc);
		final String suffix = localName.substring(starLoc + 1);
		File matches[] = dir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				if (!name.startsWith(prefix))
					return false;
				return name.endsWith(suffix);
			}

		});
		for (int i = 0; i < matches.length; i++)
			realm.addConstituent(matches[i].toURL());

	}

	protected String filter(String text) throws ConfigurationException {
		String result = "";
		int cur = 0;
		int textLen = text.length();
		int propStart = -1;
		int propStop = -1;
		String propName = null;
		String propValue = null;
		do {
			if (cur >= textLen)
				break;
			propStart = text.indexOf("${", cur);
			if (propStart < 0)
				break;
			result = result + text.substring(cur, propStart);
			propStop = text.indexOf("}", propStart);
			if (propStop < 0)
				throw new ConfigurationException("Unterminated property: "
						+ text.substring(propStart));
			propName = text.substring(propStart + 2, propStop);
			propValue = System.getProperty(propName);
			if (propValue == null)
				throw new ConfigurationException("No such property: "
						+ propName);
			result = result + propValue;
			cur = propStop + 1;
		} while (true);
		result = result + text.substring(cur);
		return result;
	}

	/* ******** Getter Setters *************** */
	public GuiLauncher getGuiLauncher() {
		return guiLauncher;
	}

	public void setGuiLauncher(GuiLauncher guiLauncher) {
		this.guiLauncher = guiLauncher;
	}

	public ClassWorld getWorld() {
		return world;
	}

	public void setWorld(ClassWorld world) {
		this.world = world;
	}

	public Map getConfiguredRealms() {
		return configuredRealms;
	}

	public void setConfiguredRealms(Map configuredRealms) {
		this.configuredRealms = configuredRealms;
	}
}
