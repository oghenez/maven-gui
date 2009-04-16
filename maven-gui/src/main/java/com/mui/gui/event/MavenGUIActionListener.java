/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.event.MavenGUIActionListener.java
 * Type		: com.mui.gui.event.MavenGUIActionListener
 * 
 * Date		: Apr 8, 2009	1:56:41 PM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mui.MavenGuiConstants;
import com.mui.gui.comp.OpenDialog;

/**
 * @author sabuj.das
 *
 */
public class MavenGUIActionListener implements ActionListener, MavenGuiConstants {

	private Component eventSource;
	private Component eventTarget;
	
	

	public Component getEventSource() {
		return eventSource;
	}

	public void setEventSource(Component eventSource) {
		this.eventSource = eventSource;
	}

	public Component getEventTarget() {
		return eventTarget;
	}

	public void setEventTarget(Component eventTarget) {
		this.eventTarget = eventTarget;
	}

	public void handelEvent(ActionEvent event){
		actionPerformed(event);
	}
	

	public void actionPerformed(ActionEvent event) {
		if(event == null)
			return;
		String cmd = event.getActionCommand();
		
		if(EXIT_CMD.equals(cmd)){
			System.exit(0);
		} else if(CREATE_PROJECT_CMD.equals(cmd)){
			OpenDialog.openCreateProjectDialog(eventSource, true);
			
		} else if(DEPENDENCY_BROWSER_CMD.equals(cmd)){
			JOptionPane.showMessageDialog(eventSource, cmd);
		}
	}

}
