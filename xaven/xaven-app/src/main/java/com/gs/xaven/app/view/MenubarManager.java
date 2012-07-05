/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gs.xaven.app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Sabuj Das | sabuj.das@gmail.com
 */
public class MenubarManager implements ActionListener{

	public static final String CMD_CREATE_PROJECT_MENU_ITEM = "CMD_CREATE_PROJECT_MENU_ITEM";
	
	private final ActionListener actionListener;

	
	public MenubarManager(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public ActionListener getActionListener() {
		return actionListener;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		
	}

	public JMenu createMenu(String text){
		return new JMenu(text);
	}
	
	public JMenuItem createMenuItem(String text, String cmd){
		JMenuItem item = new JMenuItem(text);
		item.addActionListener(getActionListener());
		item.setActionCommand(cmd);
		return item;
	}
	
	
	public JMenu createFileMenu(){
		JMenu fileMenu = createMenu("File");
		
		fileMenu.add(createMenuItem("New Project", CMD_CREATE_PROJECT_MENU_ITEM));
		
		return fileMenu;
	}
}
