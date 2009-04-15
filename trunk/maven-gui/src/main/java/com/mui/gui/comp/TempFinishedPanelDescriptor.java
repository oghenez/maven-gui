/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.comp.TempFinishedPanelDescriptor.java
 * Type		: com.mui.gui.comp.TempFinishedPanelDescriptor
 * 
 * Date		: Apr 8, 2009	6:04:50 PM
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
public class TempFinishedPanelDescriptor extends WizardPanelDescriptor {

	public static final String IDENTIFIER = "TempFinishedPanelDescriptor";
	
	TempFinishedPanel panel;
	
	public TempFinishedPanelDescriptor() {
		panel = new TempFinishedPanel();
		setPanelDescriptorIdentifier(IDENTIFIER);
        setPanelComponent(panel);
	}
	
	public Object getNextPanelDescriptor() {
        return FINISH;
    }
    
    public Object getBackPanelDescriptor() {
        return CreateProjectPanelDescriptor.IDENTIFIER;
    }
}
