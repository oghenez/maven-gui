/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.comp.MavenMenuBar.java
 * Type		: com.mui.gui.comp.MavenMenuBar
 * 
 * Date		: Apr 8, 2009	11:44:39 AM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui.comp;

import java.awt.event.*;

import javax.swing.*;

import org.fife.plaf.Office2003.Office2003LookAndFeel;
import org.jvnet.substance.skin.*;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;
import com.mui.gui.event.MavenGUIActionListener;

import de.muntjak.tinylookandfeel.TinyLookAndFeel;

/**
 * @author sabuj.das
 *
 */
public class MavenMenuBar extends JMenuBar implements MavenGuiConstants{

	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	private JMenu fileMenu, editMenu, pluginsMenu, toolsMenu, viewMenu, helpMenu; 
	private JFrame parentFrame;
	private MavenGUIActionListener listener = new MavenGUIActionListener();
	
	
	public MavenMenuBar(JFrame f) {
		parentFrame = f;
		listener.setEventSource(parentFrame);
		fileMenu = createFileMenu();
		add(fileMenu);
		editMenu = creteEditMenu();
		add(editMenu);
		pluginsMenu = createPluginsMenu();
		add(pluginsMenu);
		toolsMenu = createToolsMenu();
		add(toolsMenu);
		viewMenu = createViewMenu();
		add(viewMenu);
		helpMenu = createHelpMenu();
		add(helpMenu);
	}

	private JMenu createHelpMenu() {
		JMenu menu = new JMenu("Help");
		return menu;
	}

	private JMenu createViewMenu() {
		JMenu menu = new JMenu("View");
		
		JMenu lNfMenu = createLNFMenu();
		
        menu.add(lNfMenu);
		
		return menu;
	}

	private JMenu createLNFMenu() {
		ButtonGroup lNfMenuButtonGroup = new ButtonGroup();
		JMenu lNfMenu = new JMenu("Look n Feel");
		//lNfMenu.setIcon();
		
		JRadioButtonMenuItem crossPlfRadioButtonMenuItem = new JRadioButtonMenuItem("Cross Platform");
        crossPlfRadioButtonMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(UIManager.getCrossPlatformLookAndFeelClassName());
            }
        });
        lNfMenuButtonGroup.add(crossPlfRadioButtonMenuItem);
        lNfMenu.add(crossPlfRadioButtonMenuItem);

        JRadioButtonMenuItem office2003RadioButtonMenuItem = new JRadioButtonMenuItem("Office 2003");
        office2003RadioButtonMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(Office2003LookAndFeel.class.getCanonicalName());
            }
        });
        lNfMenuButtonGroup.add(office2003RadioButtonMenuItem);
        lNfMenu.add(office2003RadioButtonMenuItem);
        JRadioButtonMenuItem tinyRadioButtonMenuItem = new JRadioButtonMenuItem("Forest");
        tinyRadioButtonMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(TinyLookAndFeel.class.getCanonicalName());
            }
        });
        lNfMenuButtonGroup.add(tinyRadioButtonMenuItem);
        lNfMenu.add(tinyRadioButtonMenuItem);
        JRadioButtonMenuItem winRadioButtonMenuItem = new JRadioButtonMenuItem("System");
        winRadioButtonMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(UIManager.getSystemLookAndFeelClassName());
            }
        });
        winRadioButtonMenuItem.setSelected(true);
        lNfMenuButtonGroup.add(winRadioButtonMenuItem);
        lNfMenu.add(winRadioButtonMenuItem);

        JMenu substanceLnFgroupMenu = new JMenu("Substance Group");
        JRadioButtonMenuItem substanceAutumnLookAndFeel = new JRadioButtonMenuItem("Autumn");
        JRadioButtonMenuItem substanceBusinessLookAndFeel = new JRadioButtonMenuItem("Business");
        JRadioButtonMenuItem substanceBBlackSteelLookAndFeel = new JRadioButtonMenuItem("Business Black Steel");
        JRadioButtonMenuItem substanceBBlueSteelLookAndFeel = new JRadioButtonMenuItem("Business Blue Steel");
        JRadioButtonMenuItem substanceChallengerDeepLookAndFeel = new JRadioButtonMenuItem("Challenger Deep");
        JRadioButtonMenuItem substanceCremeCoffeeLookAndFeel = new JRadioButtonMenuItem("Creme Coffee");
        JRadioButtonMenuItem substanceCremeLookAndFeel = new JRadioButtonMenuItem("Creme");
        JRadioButtonMenuItem substanceEmeraldDuskLookAndFeel = new JRadioButtonMenuItem("Emerald Dusk");
        JRadioButtonMenuItem substanceMagmaLookAndFeel = new JRadioButtonMenuItem("Magma");
        JRadioButtonMenuItem substanceMistAquaLookAndFeel = new JRadioButtonMenuItem("Mist Aqua");
        JRadioButtonMenuItem substanceMistSilverLookAndFeel = new JRadioButtonMenuItem("Mist Silver");
        JRadioButtonMenuItem substanceModerateLookAndFeel = new JRadioButtonMenuItem("Moderate");
        JRadioButtonMenuItem substanceNebulaBrickWallLookAndFeel = new JRadioButtonMenuItem("Nebula Brick Wall");
        JRadioButtonMenuItem substanceNebulaLookAndFeel = new JRadioButtonMenuItem("Nebule");
        JRadioButtonMenuItem substanceOfficeBlue2007LookAndFeel = new JRadioButtonMenuItem("Office Blue 2007");
        JRadioButtonMenuItem substanceOfficeSilver2007LookAndFeel = new JRadioButtonMenuItem("Office Silver 2007");
        JRadioButtonMenuItem substanceGraphiteLookAndFeel = new JRadioButtonMenuItem("Graphite");
        JRadioButtonMenuItem substanceGraphiteGlassLookAndFeel = new JRadioButtonMenuItem("graphite Glass");
        JRadioButtonMenuItem substanceRavenLookAndFeel = new JRadioButtonMenuItem("Raven");
        JRadioButtonMenuItem substanceSaharaLookAndFeel = new JRadioButtonMenuItem("Sahara");

        lNfMenuButtonGroup.add(substanceAutumnLookAndFeel);
        lNfMenuButtonGroup.add(substanceBBlackSteelLookAndFeel);
        lNfMenuButtonGroup.add(substanceBBlueSteelLookAndFeel);
        lNfMenuButtonGroup.add(substanceChallengerDeepLookAndFeel);
        lNfMenuButtonGroup.add(substanceCremeCoffeeLookAndFeel);
        lNfMenuButtonGroup.add(substanceCremeLookAndFeel);
        lNfMenuButtonGroup.add(substanceEmeraldDuskLookAndFeel);
        lNfMenuButtonGroup.add(substanceMagmaLookAndFeel);
        lNfMenuButtonGroup.add(substanceMistAquaLookAndFeel);
        lNfMenuButtonGroup.add(substanceMistSilverLookAndFeel);
        lNfMenuButtonGroup.add(substanceModerateLookAndFeel);
        lNfMenuButtonGroup.add(substanceNebulaBrickWallLookAndFeel);
        lNfMenuButtonGroup.add(substanceNebulaLookAndFeel);
        lNfMenuButtonGroup.add(substanceOfficeSilver2007LookAndFeel);
        lNfMenuButtonGroup.add(substanceGraphiteLookAndFeel);
        lNfMenuButtonGroup.add(substanceGraphiteGlassLookAndFeel);
        lNfMenuButtonGroup.add(substanceRavenLookAndFeel);
        lNfMenuButtonGroup.add(substanceSaharaLookAndFeel);

        substanceBusinessLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceBusinessLookAndFeel.class.getCanonicalName());
            }
        });
        lNfMenuButtonGroup.add(substanceBusinessLookAndFeel);

        substanceOfficeBlue2007LookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceOfficeBlue2007LookAndFeel.class.getCanonicalName());
            }
        });
        lNfMenuButtonGroup.add(substanceOfficeBlue2007LookAndFeel);

        substanceAutumnLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceAutumnLookAndFeel.class.getCanonicalName());
            }
        });
        substanceBBlackSteelLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceBusinessBlackSteelLookAndFeel.class.getCanonicalName());
            }
        });
        substanceBBlueSteelLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceBusinessBlueSteelLookAndFeel.class.getCanonicalName());
            }
        });
        substanceChallengerDeepLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceChallengerDeepLookAndFeel.class.getCanonicalName());
            }
        });
        substanceCremeCoffeeLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceCremeCoffeeLookAndFeel.class.getCanonicalName());
            }
        });
        substanceCremeLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceCremeLookAndFeel.class.getCanonicalName());
            }
        });
        substanceEmeraldDuskLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceEmeraldDuskLookAndFeel.class.getCanonicalName());
            }
        });
        substanceMagmaLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceMagmaLookAndFeel.class.getCanonicalName());
            }
        });
        substanceMistAquaLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceMistAquaLookAndFeel.class.getCanonicalName());
            }
        });
        substanceMistSilverLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceMistSilverLookAndFeel.class.getCanonicalName());
            }
        });
        substanceModerateLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceModerateLookAndFeel.class.getCanonicalName());
            }
        });
        substanceNebulaBrickWallLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceNebulaBrickWallLookAndFeel.class.getCanonicalName());
            }
        });
        substanceNebulaLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceNebulaLookAndFeel.class.getCanonicalName());
            }
        });
        substanceOfficeSilver2007LookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceOfficeSilver2007LookAndFeel.class.getCanonicalName());
            }
        });
        substanceGraphiteLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceRavenGraphiteLookAndFeel.class.getCanonicalName());
            }
        });
        substanceGraphiteGlassLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceRavenGraphiteGlassLookAndFeel.class.getCanonicalName());
            }
        });
        substanceRavenLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceRavenLookAndFeel.class.getCanonicalName());
            }
        });
        substanceSaharaLookAndFeel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                updateLnF(SubstanceSaharaLookAndFeel.class.getCanonicalName());
            }
        });


        substanceLnFgroupMenu.add(substanceAutumnLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceBusinessLookAndFeel);
        substanceLnFgroupMenu.add(substanceBBlackSteelLookAndFeel);
        substanceLnFgroupMenu.add(substanceBBlueSteelLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceChallengerDeepLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceCremeCoffeeLookAndFeel);
        substanceLnFgroupMenu.add(substanceCremeLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceEmeraldDuskLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceMagmaLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceMistAquaLookAndFeel);
        substanceLnFgroupMenu.add(substanceMistSilverLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceModerateLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceNebulaBrickWallLookAndFeel);
        substanceLnFgroupMenu.add(substanceNebulaLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceOfficeBlue2007LookAndFeel);
        substanceLnFgroupMenu.add(substanceOfficeSilver2007LookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceGraphiteLookAndFeel);
        substanceLnFgroupMenu.add(substanceGraphiteGlassLookAndFeel);
        substanceLnFgroupMenu.add(substanceRavenLookAndFeel);
        substanceLnFgroupMenu.addSeparator();
        substanceLnFgroupMenu.add(substanceSaharaLookAndFeel);

        lNfMenu.add(substanceLnFgroupMenu);
        
		return lNfMenu;
	}

	private JMenu createPluginsMenu() {
		JMenu menu = new JMenu("Plugins");
		return menu;
	}

	private JMenu createToolsMenu() {
		JMenu menu = new JMenu("Tools");
		return menu;
	}

	private JMenu creteEditMenu() {
		JMenu menu = new JMenu("Edit");
		return menu;
	}

	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		ImageIcon icon = null;
		KeyStroke stroke = null;
		
		icon = new ImageIcon(IMAGE_PATH + "delete_close.png");
		stroke = KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK);
		
		
		icon = new ImageIcon(IMAGE_PATH + "newprj_wiz.gif");
		stroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK);
		menu.add(createMenuItem("Create Project", icon, stroke, CREATE_PROJECT_CMD));
		menu.addSeparator();
		
		icon = new ImageIcon(IMAGE_PATH + "class_hi.gif");
		menu.add(createMenuItem("Dependency Browser", icon, null, DEPENDENCY_BROWSER_CMD));
		menu.addSeparator();
		
		icon = new ImageIcon(IMAGE_PATH + "delete_close.png");
		stroke = KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK);
		menu.add(createMenuItem("Exit", icon, stroke, EXIT_CMD));
		return menu;
	}
	
	private JMenuItem createMenuItem(String text){
		return createMenuItem(text, null, null, text);
	}
	
	private JMenuItem createMenuItem(String text, String cmd){
		return createMenuItem(text, null, null, cmd);
	}
	
	private JMenuItem createMenuItem(
			String text, ImageIcon icon, KeyStroke stroke, String actionCommand
		){
		
		
		JMenuItem item = new JMenuItem(text);
		if(icon != null)
			item.setIcon(icon);
		if(stroke != null)
			item.setAccelerator(stroke);
		if(actionCommand != null)
			item.setActionCommand(actionCommand);
		item.addActionListener(listener);
		return item;
	}
	
	private void updateLnF(String className) {
        try {
            UIManager.setLookAndFeel(className);
            context.setLookNfeelClassName(className);
        } catch (Exception ex) {
            System.err.println("Cannot load LnF");
            ex.printStackTrace();

        }
        SwingUtilities.updateComponentTreeUI(parentFrame);
    }
	
}
