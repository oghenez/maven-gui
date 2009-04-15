/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.DefaultPluginPanel.java
 * Date		:	Dec 15, 2008 __ 11:42:23 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.*;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;
import com.mui.core.cmd.CommandLineConstants;
import com.mui.core.cmd.CommandLineCreator;
import com.mui.gui.log4j.MavenTask;



/**
 * @author sabuj.das
 *
 */
public class DefaultPluginPanel extends JPanel implements MavenGuiConstants {

	private CommandLineCreator commandLineCreator;
	private MavenGUIContext context = MavenGUIContext.getInstance();
	
	public DefaultPluginPanel() {
		commandLineCreator = new CommandLineCreator();
		initComponents();
        
    }
	private void initComponents() {

        jLabel1 = new JLabel();
        rootProjectTextField = new JTextField();
        jButton1 = new JButton();
        jPanel1 = new JPanel();
        cleanCheckBox = new JCheckBox();
        compileCheckBox = new JCheckBox();
        installCheckBox = new JCheckBox();
        profileTextField = new JTextField();
        jLabel3 = new JLabel();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();
        cmdTextField = new JTextField();
        execStopButton = new JButton();
        jPanel4 = new JPanel();
        jarCpLocCheckBox = new JCheckBox();
        browseJarCpLocButton = new JButton();
        jarCpLocTextField = new JTextField();
        cpJarButton = new JButton();

        jLabel1.setText("Root: ");

        rootProjectTextField.setText("");
        

        jButton1.setIcon(new ImageIcon(IMAGE_PATH+"folder_up_level.png")); // NOI18N

        jPanel1.setBorder(BorderFactory.createTitledBorder(" MVN "));

        cleanCheckBox.setFont(new Font("Monospaced", 1, 12));
        cleanCheckBox.setSelected(false);
        cleanCheckBox.setText("clean");
        cleanCheckBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(cleanCheckBox.isSelected()){
					String cmd = commandLineCreator.updateCommandLine(cmdTextField.getText(), CommandLineConstants.MVN_CLEAN, true);
					cmdTextField.setText(cmd.trim());
				}
				if(!cleanCheckBox.isSelected()){
					String cmd = commandLineCreator.updateCommandLine(cmdTextField.getText(), CommandLineConstants.MVN_CLEAN, false);
					cmdTextField.setText(cmd.trim());
				}
			}
    	});

        compileCheckBox.setFont(new Font("Monospaced", 1, 12));
        compileCheckBox.setText("compile");
        compileCheckBox.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					if(compileCheckBox.isSelected()){
						String cmd = commandLineCreator.updateCommandLine(cmdTextField.getText(), CommandLineConstants.MVN_COMPILE, true);
						cmdTextField.setText(cmd.trim());
					}
					if(!compileCheckBox.isSelected()){
						String cmd = commandLineCreator.updateCommandLine(cmdTextField.getText(), CommandLineConstants.MVN_COMPILE, false);
						cmdTextField.setText(cmd.trim());
					}
				}
        	});

        installCheckBox.setFont(new Font("Monospaced", 1, 12));
        installCheckBox.setSelected(false);
        installCheckBox.setText("install");
        installCheckBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(installCheckBox.isSelected()){
					String cmd = commandLineCreator.updateCommandLine(cmdTextField.getText(), CommandLineConstants.MVN_INSTALL, true);
					cmdTextField.setText(cmd.trim());
				}
				if(!installCheckBox.isSelected()){
					String cmd = commandLineCreator.updateCommandLine(cmdTextField.getText(), CommandLineConstants.MVN_INSTALL, false);
					cmdTextField.setText(cmd.trim());
				}
			}
    	});

        profileTextField.setFont(new Font("Monospaced", 1, 12));
        profileTextField.setText("");

        jLabel3.setText("Profile");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(installCheckBox)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cleanCheckBox)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(compileCheckBox)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(profileTextField, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cleanCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compileCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(installCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(profileTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createTitledBorder(" Options "));

        jList1.setModel(new AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
        );

        jPanel3.setBorder(BorderFactory.createTitledBorder(" Execuit "));

        jLabel2.setText("CMD: ");

        cmdTextField.setText("");

        execStopButton.setText("Execuit");
        execStopButton.setIcon(new ImageIcon(IMAGE_PATH+"agt_runit.png")); 
        execStopButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		execuitCommand();
        	}
        });
        

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdTextField, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addComponent(execStopButton, GroupLayout.Alignment.TRAILING)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(execStopButton)
                .addContainerGap())
        );

        jPanel4.setBorder(BorderFactory.createTitledBorder(" Jar Copy "));

        jarCpLocCheckBox.setText("Copy to default location");
        jarCpLocCheckBox.setSelected(true);
        jarCpLocCheckBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(jarCpLocCheckBox.isSelected()){
					browseJarCpLocButton.setEnabled(false);
					jarCpLocTextField.setEnabled(false);
				}
				if(!jarCpLocCheckBox.isSelected()){
					browseJarCpLocButton.setEnabled(true);
					jarCpLocTextField.setEnabled(true);
				}
			}
    	});

        browseJarCpLocButton.setText("Browse");
        browseJarCpLocButton.setEnabled(false);

        jarCpLocTextField.setText("%WAR_DIR%/WEB_INF/lib");
        jarCpLocTextField.setEnabled(false);

        cpJarButton.setText("Copy JAR");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jarCpLocTextField, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jarCpLocCheckBox)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                            .addComponent(browseJarCpLocButton)))
                    .addComponent(cpJarButton, GroupLayout.Alignment.TRAILING)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jarCpLocCheckBox)
                    .addComponent(browseJarCpLocButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jarCpLocTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cpJarButton))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rootProjectTextField, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(rootProjectTextField)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
	
	private void execuitCommand() {
        String cmd = cmdTextField.getText();
        String[] args = null;
        if(cmd != null){
            args = cmd.split(" ");
        }
		
        mavenTask.setCmdLineArgs(args);
        mavenTask.execute();
	}

    private MavenTask mavenTask = new MavenTask(0, "Zero");
	private JButton jButton1;
    private JButton execStopButton;
    private JButton browseJarCpLocButton;
    private JButton cpJarButton;
    private JCheckBox cleanCheckBox;
    private JCheckBox compileCheckBox;
    private JCheckBox jarCpLocCheckBox;
    private JCheckBox installCheckBox;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JList jList1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JTextField rootProjectTextField;
    private JTextField profileTextField;
    private JTextField cmdTextField;
    private JTextField jarCpLocTextField;
}
