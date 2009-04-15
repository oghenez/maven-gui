/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.DefaultOutputPanel.java
 * Date		:	Dec 13, 2008 __ 10:46:47 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;



import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.mui.MavenGuiConstants;

/**
 * @author sabuj.das
 *
 */
public class DefaultOutputPanel extends JPanel implements MavenGuiConstants {

	public DefaultOutputPanel() {
        
        initComponents();
        
    }
	
	private void initComponents() {
        setBackground(PANEL_BG);
        outputTabbedPane = new JTabbedPane();
        outputTabbedPane.setBackground(PANEL_BG);
        consoleOutputPanel = new ConsoleOutputPanel();
        outputTabbedPane.addTab("Console", consoleOutputPanel);
        taskProgressPanel = new TaskProgressPanel();
        outputTabbedPane.addTab("Progress", taskProgressPanel);
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(outputTabbedPane, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(outputTabbedPane, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );
    }
	
	
	
	private ConsoleOutputPanel consoleOutputPanel;
	private JTabbedPane outputTabbedPane;
	private TaskProgressPanel taskProgressPanel;
	
}
