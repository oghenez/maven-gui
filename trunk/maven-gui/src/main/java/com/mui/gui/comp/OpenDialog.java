/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.comp.OpenDialog.java
 * Type		: com.mui.gui.comp.OpenDialog
 * 
 * Date		: Apr 8, 2009	2:14:30 PM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui.comp;

import java.awt.Component;
import java.awt.Frame;

import javax.swing.JOptionPane;

import com.mui.gui.wizard.Wizard;
import com.mui.gui.wizard.WizardPanelDescriptor;

/**
 * @author sabuj.das
 *
 */
public class OpenDialog {

	
	public static void openCreateProjectDialog(Component parent, boolean model){
		Wizard wizard = new Wizard((Frame)parent);
        wizard.getDialog().setTitle("Create Maven Project ...");
        wizard.getDialog().setLocation(parent.getLocation());
        
        WizardPanelDescriptor descriptor1 = new ProjectTypePanelDescriptor();
        wizard.registerWizardPanel(ProjectTypePanelDescriptor.IDENTIFIER, descriptor1);

        WizardPanelDescriptor descriptor2 = new CreateProjectPanelDescriptor();
        wizard.registerWizardPanel(CreateProjectPanelDescriptor.IDENTIFIER, descriptor2);

        WizardPanelDescriptor descriptor3 = new TempFinishedPanelDescriptor();
        wizard.registerWizardPanel(TempFinishedPanelDescriptor.IDENTIFIER, descriptor3);
        
        wizard.setCurrentPanel(ProjectTypePanelDescriptor.IDENTIFIER);
        
        int ret = wizard.showModalDialog();
        
        System.out.println("RET = " + ret);
        
	}
	
}
