/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.comp.CreateProjectPanelDescriptor.java
 * Type		: com.mui.gui.comp.CreateProjectPanelDescriptor
 * 
 * Date		: Apr 8, 2009	3:13:20 PM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui.comp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mui.MavenGuiConstants;
import com.mui.gui.wizard.WizardPanelDescriptor;

/**
 * @author sabuj.das
 *
 */
public class ProjectTypePanelDescriptor extends WizardPanelDescriptor  implements ListSelectionListener {

	public static final String IDENTIFIER = "ProjectTypeSelectionPanel";
	
	private ProjectTypeSelectionPanel projectTypeSelectionPanel ;
	private String selectedProjectType = "NA";
	
	public ProjectTypePanelDescriptor() {
		projectTypeSelectionPanel = new ProjectTypeSelectionPanel();
		setPanelDescriptorIdentifier(IDENTIFIER);
		
		setPanelComponent(projectTypeSelectionPanel);
		projectTypeSelectionPanel.addListActionListener(this);
	}
	
	public Object getNextPanelDescriptor() {
        String desc = "";
        if(MavenGuiConstants.ARCHETYPE_CREATE_PLUGIN.equals(selectedProjectType)){
        	desc = CreateProjectPanelDescriptor.IDENTIFIER;
    	} else if(MavenGuiConstants.ARCHETYPE_GENERATE_PLUGIN.equals(selectedProjectType)){
    		
    	} else if(MavenGuiConstants.ARCHETYPE_CREATE_FROM_PROJECT_PLUGIN.equals(selectedProjectType)){
    		
    	} else if(MavenGuiConstants.ARCHETYPE_CRAWL_PLUGIN.equals(selectedProjectType)){
    		
    	} else{
    		desc = IDENTIFIER;
    	}
        setNextButtonAccordingToListSelection();
		return desc;
    }
	
    public Object getBackPanelDescriptor() {
        return null;
    }  
	
    public void actionPerformed(ActionEvent e) {
        setNextButtonAccordingToListSelection();
    }
            
    
    private void setNextButtonAccordingToListSelection() {
    	selectedProjectType = projectTypeSelectionPanel.getSelectedProjectType();
    	if(MavenGuiConstants.NA.equals(selectedProjectType)){
    		getWizard().setNextFinishButtonEnabled(false);
    	}else{
    		getWizard().setNextFinishButtonEnabled(true);
    	}
    	
    }

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		setNextButtonAccordingToListSelection();
		
	}



	
}
