/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.panels.ConsoleOutputPanel.java
 * Date		:	Dec 13, 2008 __ 10:34:32 AM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.panels;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.ToolBarUI;

import org.apache.log4j.Level;
import org.apache.log4j.WriterAppender;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;
import com.mui.gui.io.impl.JTextAreaWriter;
import com.mui.gui.log4j.FlexibleLayout;
import com.mui.gui.log4j.MainLogger;

/**
 * @author sabuj.das
 *
 */
public class ConsoleOutputPanel extends JPanel implements MavenGuiConstants{

	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	public ConsoleOutputPanel() {
        initComponents();
    }
	
	private void initComponents() {
        cButtonToolBar = new JToolBar();
        clearConsoleButton = new JButton();
        copyTextButton = new JButton();
        saveTextButton = new JButton();
        saveTextAsButton = new JButton();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        consoleTextArea = new JTextArea();
        consoleSettingsButton = new JButton();

        cButtonToolBar.setFloatable(false);
        cButtonToolBar.setRollover(true);

        clearConsoleButton.setIcon(new ImageIcon(IMAGE_PATH +"delete_close.png"));
        clearConsoleButton.setFocusable(false);
        clearConsoleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        clearConsoleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        clearConsoleButton.setToolTipText("Clear console");
        clearConsoleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consoleTextArea.setText("");
            }
        });
        cButtonToolBar.add(clearConsoleButton);

        copyTextButton.setIcon(new ImageIcon(IMAGE_PATH+"copy.gif"));
        copyTextButton.setFocusable(false);
        copyTextButton.setHorizontalTextPosition(SwingConstants.CENTER);
        copyTextButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        copyTextButton.setToolTipText("Copy text");
        cButtonToolBar.add(copyTextButton);

        saveTextButton.setIcon(new ImageIcon(IMAGE_PATH + "filesave.png")); 
        saveTextButton.setFocusable(false);
        saveTextButton.setHorizontalTextPosition(SwingConstants.CENTER);
        saveTextButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        saveTextButton.setToolTipText("Save text");
        cButtonToolBar.add(saveTextButton);

        saveTextAsButton.setIcon(new ImageIcon(IMAGE_PATH+"saveas.gif")); 
        saveTextAsButton.setFocusable(false);
        saveTextAsButton.setHorizontalTextPosition(SwingConstants.CENTER);
        saveTextAsButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        saveTextAsButton.setToolTipText("Save text as");
        cButtonToolBar.add(saveTextAsButton);

        

        consoleTextArea.setColumns(20);
        consoleTextArea.setEditable(false);
        consoleTextArea.setRows(5);
        consoleTextArea.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(consoleTextArea);
        JTextAreaWriter textAreaWriter = new JTextAreaWriter(consoleTextArea);
		context.setTextAreaWriter(textAreaWriter);
        WriterAppender appender = new WriterAppender(new FlexibleLayout(), textAreaWriter);
        MainLogger.init(appender, Level.ALL);
        MainLogger.logInfo("Logger initialized....");
        consoleSettingsButton.setIcon(new ImageIcon(IMAGE_PATH+"tools.gif")); 
        consoleSettingsButton.setToolTipText("Console settings");
        consoleSettingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cButtonToolBar, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consoleSettingsButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(consoleSettingsButton)
                    .addComponent(cButtonToolBar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
        );
    }
	
	private JToolBar cButtonToolBar;
    private JButton clearConsoleButton;
    private JButton consoleSettingsButton;
    private JTextArea consoleTextArea;
    private JButton copyTextButton;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JButton saveTextAsButton;
    private JButton saveTextButton;
}
