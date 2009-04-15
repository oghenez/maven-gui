/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.VeriableComponentMainPanel.java
 * Date		:	Dec 13, 2008 __ 11:26:45 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import com.mui.*;
/**
 * @author sabuj.das
 *
 */
public class VariableComponentMainPanel extends JPanel implements
MavenGuiConstants {

	public VariableComponentMainPanel() {
        initComponents();
    }
	
	private void initComponents() {
        setLayout(new BorderLayout());
    }
	
	public void addComponent(Component component){
		addComponent(component, BorderLayout.CENTER);
	}
	
	public void addComponent(Component component, String index){
		removeAll();
        setLayout(new BorderLayout());
        add(component, index);
		updateUI();
	}

	
	private Component component;
}
