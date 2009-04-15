/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.MavenPropertiesPanel.java
 * Date		:	Dec 13, 2008 __ 12:21:01 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;

/**
 * @author sabuj.das
 *
 */
public class MavenPropertiesPanel extends JPanel implements MavenGuiConstants{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4015666193435522926L;
	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	public MavenPropertiesPanel() {
		initComponents();
	}
	
	private void initComponents() {
		
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

        headerPanel = new JPanel();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        mavenPropertiesTable = new JTable();
        addPropButton = new JButton();
        deletePropButton = new JButton();
        editPropButton = new JButton();

        setLayout(new GridBagLayout());

        headerPanel.setBorder(BorderFactory.createEtchedBorder());
        headerPanel.setPreferredSize(new Dimension(400, 40));
        headerPanel.setBackground(PANEL_HEADER_BG);
        
        jLabel1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Maven ENV Variables");

        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(headerPanel, gridBagConstraints);

        mavenPropertiesTable.setModel(new DefaultTableModel(
            new Object [][] {
                {"java.home", null},
                {"maven.home", null}
            },
            new String [] {
                "ENV Var", "Value"
            }
        ));
        jScrollPane1.setViewportView(mavenPropertiesTable);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        addPropButton.setText("");
        addPropButton.setToolTipText("Add New Property");
        addPropButton.setIcon(new ImageIcon(IMAGE_PATH+"add_plus.png")); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.SOUTHWEST;
        add(addPropButton, gridBagConstraints);

        deletePropButton.setText("");
        deletePropButton.setToolTipText("Delete Property");
        deletePropButton.setIcon(new ImageIcon(IMAGE_PATH+"remove_minus.png")); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.SOUTHWEST;
        add(deletePropButton, gridBagConstraints);

        editPropButton.setText("");
        editPropButton.setToolTipText("Modefy Property");
        editPropButton.setIcon(new ImageIcon(IMAGE_PATH+"edit_pen.png")); 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.SOUTHWEST;
        add(editPropButton, gridBagConstraints);
    }
	
	private JButton addPropButton;
    private JButton deletePropButton;
    private JButton editPropButton;
    private JPanel headerPanel;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable mavenPropertiesTable;
}
