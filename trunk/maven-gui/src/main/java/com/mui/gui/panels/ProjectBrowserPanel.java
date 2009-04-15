/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.ProjectBrowserPanel.java
 * Date		:	Dec 9, 2008 __ 12:50:52 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;

import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;
import com.mui.gui.comp.DirectoryTree;

/**
 * @author sabuj.das
 *
 */
public class ProjectBrowserPanel extends JPanel implements MavenGuiConstants{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4472367600300634528L;
	
	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	
	public ProjectBrowserPanel() {
		initcomponents();
	}

	private void initcomponents() {
		try {
			UIManager.setLookAndFeel(context.getLookNfeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		GridBagConstraints gridBagConstraints;

        buttonToolBar = new JToolBar();
        backButton = new JButton();
        nextButton = new JButton();
        jSeparator1 = new JToolBar.Separator();
        upButton = new JButton();
        refreshButton = new JButton();
        addressTextField = new JTextField();
        jScrollPane1 = new JScrollPane();
        directoryTree = new DirectoryTree();
        goButton = new JButton();
        
        directoryTree.setDisplayTextField(addressTextField);
        
        setLayout(new GridBagLayout());

        buttonToolBar.setRollover(true);
        buttonToolBar.setFloatable(false);

        backButton.setText("");
        backButton.setIcon(new ImageIcon(IMAGE_PATH+"back_previous.png")); 
        backButton.setFocusable(false);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttonToolBar.add(backButton);

        nextButton.setText("");
        nextButton.setIcon(new ImageIcon(IMAGE_PATH+"forward_next.png")); 
        nextButton.setFocusable(false);
        nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
        nextButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttonToolBar.add(nextButton);
        buttonToolBar.add(jSeparator1);

        upButton.setText("");
        upButton.setIcon(new ImageIcon(IMAGE_PATH+"folder_up_level.png")); 
        upButton.setFocusable(false);
        upButton.setHorizontalTextPosition(SwingConstants.CENTER);
        upButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttonToolBar.add(upButton);

        refreshButton.setText("");
        refreshButton.setIcon(new ImageIcon(IMAGE_PATH+"reload_green.png")); 
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttonToolBar.add(refreshButton);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        add(buttonToolBar, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(1, 0, 1, 0);
        add(addressTextField, gridBagConstraints);

        jScrollPane1.setViewportView(directoryTree);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        goButton.setIcon(new ImageIcon(IMAGE_PATH+"next.png"));
        goButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        add(goButton, gridBagConstraints);
	}
	
	private JButton backButton;
    private JScrollPane jScrollPane1;
    private JToolBar.Separator jSeparator1;
    private JToolBar buttonToolBar;
    private DirectoryTree directoryTree;
    private JButton nextButton;
    private JButton refreshButton;
    private JButton upButton;
    private JTextField addressTextField;
    private JButton goButton;
}
