/**
 *  Personal Information Manager
 * -------------------------------------------
 * File : jpim.ui.panel.HeaderPanel.java
 * Date : Oct 12, 2008 2:14:35 AM
 */
package com.mui.gui.panels;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;


/**
 * @author user
 *
 */
public class HeaderPanel extends JPanel implements MavenGuiConstants{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5561739323017450656L;
	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	private Icon icon;
	private String text;
	private JLabel textLabel, iconLabel;
	

	public HeaderPanel(Icon icon, String text) {
		try {
			UIManager.setLookAndFeel(context.getLookNfeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.icon = icon;
		this.text = (text == null) ? "" : text;
		textLabel = new JLabel(text);
		textLabel.setFont(HEADER_TXET_FONT);
		textLabel.setForeground(HEARED_TEXT_FG);
		
		setBackground(PANEL_HEADER_BG);
		setLayout(new BorderLayout());
		if(icon != null){
			iconLabel = new JLabel(icon);
			add(iconLabel, BorderLayout.WEST);
		}
		add(textLabel, BorderLayout.EAST);
		
		
	}


	public Icon getIcon() {
		return icon;
	}


	public String getText() {
		return text;
	}


	public void setIcon(Icon icon) {
		this.icon = icon;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	
}
