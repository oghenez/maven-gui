/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.comp.ProjectTypeSelectionPanel.java
 * Type		: com.mui.gui.comp.ProjectTypeSelectionPanel
 * 
 * Date		: Apr 8, 2009	2:57:12 PM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui.comp;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import com.mui.MavenGuiConstants;

import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

/**
 * @author sabuj.das
 *
 */
public class ProjectTypeSelectionPanel extends JPanel {

    
    public ProjectTypeSelectionPanel() {
        initComponents();
    }


    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        leftImagePanel = new  JPanel();
        leftImageLabel = new  JLabel();
        headingLabel = new  JLabel();
        listScrollPane = new  JScrollPane();
        projectTypeList = new  JList();
        typeDescriptionPanel = new  JPanel();
        typeDescriptionTextArea = new JTextArea(5,8);

        setLayout(new GridBagLayout());

        leftImagePanel.setBackground(new Color(180, 198, 239));
        leftImagePanel.setLayout(new GridBagLayout());

        leftImageLabel.setIcon(new  ImageIcon(MavenGuiConstants.IMAGE_PATH + "new_wiz.png"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        leftImagePanel.add(leftImageLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        add(leftImagePanel, gridBagConstraints);

        headingLabel.setFont(new Font("Tahoma", 1, 12)); 
        headingLabel.setText("Maven 2 Archetype Plugins");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(6, 7, 6, 0);
        add(headingLabel, gridBagConstraints);

        projectTypeList.setModel(new  AbstractListModel() {
            String[] strings = { 
            		MavenGuiConstants.ARCHETYPE_CREATE_PLUGIN,
            		MavenGuiConstants.ARCHETYPE_CREATE_FROM_PROJECT_PLUGIN,
            		MavenGuiConstants.ARCHETYPE_CRAWL_PLUGIN,
            		MavenGuiConstants.ARCHETYPE_GENERATE_PLUGIN
            	};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
            
        });
        listScrollPane.setViewportView(projectTypeList);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(3, 6, 5, 6);
        add(listScrollPane, gridBagConstraints);

        typeDescriptionPanel.setBackground(new Color(255, 255, 255));

        typeDescriptionPanel.setLayout(new BorderLayout());
        typeDescriptionPanel.add(typeDescriptionTextArea, BorderLayout.CENTER);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(3, 6, 6, 6);
        
        add(typeDescriptionPanel, gridBagConstraints);
    }

    public void addListActionListener(ListSelectionListener l) {
        projectTypeList.addListSelectionListener(l);
    }

    public boolean isSelectedFromList(){
    	return (projectTypeList.getSelectedIndex() < 0) ? false : true;
    }
    
    public String getSelectedProjectType(){
    	return (isSelectedFromList() ? projectTypeList.getSelectedValue().toString() : MavenGuiConstants.NA); 
    }
    
    
    private  JLabel leftImageLabel;
    private  JLabel headingLabel;
    private  JList projectTypeList;
    private  JPanel leftImagePanel;
    private  JPanel typeDescriptionPanel;
    private  JScrollPane listScrollPane;
    private JTextArea typeDescriptionTextArea;

}
