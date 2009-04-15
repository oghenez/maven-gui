/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.RightSplitPanePanel.java
 * Date		:	Dec 13, 2008 __ 11:04:24 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;

import javax.swing.*;
import com.mui.MavenGuiConstants;


/**
 * @author sabuj.das
 *
 */
public class RightSplitPanePanel extends JPanel implements MavenGuiConstants {

	public RightSplitPanePanel() {
        initComponents();
    }
	
	private void initComponents() {
        setBackground(PANEL_BG);
        rightSplitPane = new JSplitPane();
        defaultOutputPanel = new DefaultOutputPanel();
        variableComponentMainPanel = new VariableComponentMainPanel();
        defaultPluginPanel = new DefaultPluginPanel();
        
        variableComponentMainPanel.addComponent(defaultPluginPanel);
        rightSplitPane.setDividerSize(8);
        rightSplitPane.setDividerLocation(getWidth() - 200);
        rightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        rightSplitPane.setOneTouchExpandable(true);
        rightSplitPane.setTopComponent(variableComponentMainPanel);
        rightSplitPane.setBottomComponent(defaultOutputPanel);
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(rightSplitPane, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(rightSplitPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );
    }

    public VariableComponentMainPanel getVariableComponentMainPanel() {
        return variableComponentMainPanel;
    }

    

	private JSplitPane rightSplitPane;
	private DefaultOutputPanel defaultOutputPanel;
	private VariableComponentMainPanel variableComponentMainPanel;
	private DefaultPluginPanel defaultPluginPanel;
}
