/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.comp.CreateProjectPanelDescriptor.java
 * Type		: com.mui.gui.comp.CreateProjectPanelDescriptor
 * 
 * Date		: Apr 8, 2009	5:56:29 PM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui.comp;

import com.mui.gui.wizard.WizardPanelDescriptor;

/**
 * @author sabuj.das
 *
 */
public class CreateProjectPanelDescriptor extends WizardPanelDescriptor {

	
	public static final String IDENTIFIER = "CreateProjectPanelDescriptor";
	
	private CreateProjectPanel createProjectPanel;
	
	public CreateProjectPanelDescriptor() {
		createProjectPanel = new CreateProjectPanel();
		
		setPanelDescriptorIdentifier(IDENTIFIER);
		
		setPanelComponent(createProjectPanel);
		
	}
	
	
	public Object getNextPanelDescriptor() {
        return IDENTIFIER;
    }
    
    public Object getBackPanelDescriptor() {
        return ProjectTypePanelDescriptor.IDENTIFIER;
    }
    
    
    public void aboutToDisplayPanel() {
        //setNextButtonAccordingToCheckBox();
    }  
	
}
