/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mui.view.TestFrame;

/**
 *
 * @author sabuj.das
 */
public class MavenGUILauncher {

    public static void main(String[] args){
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                new TestFrame().setVisible(true);
            }
        });
    }
}
