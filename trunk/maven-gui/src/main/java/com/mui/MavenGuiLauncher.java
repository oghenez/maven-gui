/**
 * GUI tool for Maven
 * 
 * File		: com.mui.MavenGuiLauncher.java
 * Type		: com.mui.MavenGuiLauncher
 * 
 * Date		: Apr 8, 2009	11:15:07 AM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mui.gui.MavenGuiMainFrame;

/**
 * @author sabuj.das
 *
 */
public class MavenGuiLauncher {

	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(context.getLookNfeelClassName());
			MavenGuiMainFrame frame = new MavenGuiMainFrame();
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setVisible(true);
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
	}

}
