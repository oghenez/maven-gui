/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.MainPanel.java
 * Date		:	Dec 6, 2008 __ 1:17:26 PM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;


/**
 * @author sabuj.das
 *
 */
public class MainPanel extends JPanel implements MavenGuiConstants{

	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	public MainPanel() {
		
		initComponent();
	}

	private void initComponent() {
		setBackground(PANEL_BG);
		setLayout(new BorderLayout());
		mainSplitPane = new JSplitPane();
		rightSplitPanePanel = new RightSplitPanePanel();
		browserPanel = new ProjectBrowserPanel();
		mavenPropertiesPanel = new MavenPropertiesPanel();
		
		mainSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		mainSplitPane.setDividerLocation(250);
		mainSplitPane.setOneTouchExpandable(true);
		
		leftSplitPane = new JSplitPane();
		leftSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		leftSplitPane.setDividerLocation(250);
		leftSplitPane.setOneTouchExpandable(true);
		leftSplitPane.setTopComponent(browserPanel);
		leftSplitPane.setBottomComponent(mavenPropertiesPanel);
		
		mainSplitPane.setLeftComponent(leftSplitPane);
		mainSplitPane.setRightComponent(rightSplitPanePanel);
		
		add(mainSplitPane, BorderLayout.CENTER);
	}

    public RightSplitPanePanel getRightSplitPanePanel() {
        return rightSplitPanePanel;
    }
	
    

	private JSplitPane mainSplitPane, leftSplitPane;
	private RightSplitPanePanel rightSplitPanePanel;
	private ProjectBrowserPanel browserPanel;
	private MavenPropertiesPanel mavenPropertiesPanel;
}
