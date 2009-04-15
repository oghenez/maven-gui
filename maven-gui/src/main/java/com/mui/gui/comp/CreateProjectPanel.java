/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.comp.CreateProjectPanel.java
 * Type		: com.mui.gui.comp.CreateProjectPanel
 * 
 * Date		: Apr 8, 2009	5:02:32 PM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui.comp;

import javax.swing.*;

import com.mui.MavenGuiConstants;

import java.awt.*;


/**
 * @author sabuj.das
 *
 */
public class CreateProjectPanel extends JPanel {


    public CreateProjectPanel() {
        initComponents();
    }

 
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jPanel4 = new JPanel();
        jLabel4 = new JLabel();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(180, 198, 239));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new ImageIcon(MavenGuiConstants.IMAGE_PATH + "new_wiz.png")); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabel2.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 7, 6, 0);
        add(jLabel2, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(BorderFactory.createTitledBorder(" Required Parameters "));
        jPanel3.setPreferredSize(new java.awt.Dimension(515, 300));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanel3, gridBagConstraints);
        
        jButton1.setIcon(new ImageIcon(MavenGuiConstants.IMAGE_PATH + "add_correction.gif"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jButton1, gridBagConstraints);

        jLabel3.setText("Add Optional Parameters");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jLabel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jPanel4, gridBagConstraints);

        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setIcon(new ImageIcon(MavenGuiConstants.IMAGE_PATH + "over_co.gif"));
        jLabel4.setText("Collasp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        jPanel2.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 6, 6, 6);
        add(jPanel2, gridBagConstraints);
    }


    
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;

	
}
