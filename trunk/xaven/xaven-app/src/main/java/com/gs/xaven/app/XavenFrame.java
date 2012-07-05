/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gs.xaven.app;

/**
 *
 * @author 50120C1509
 */
public class XavenFrame extends javax.swing.JFrame {

	/**
	 * Creates new form XavenFrame
	 */
	public XavenFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectToolBar = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        statusToolBar = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        projectPanel = new javax.swing.JPanel();
        baseSplitPane = new javax.swing.JSplitPane();
        projectExplorerTabbedPane = new javax.swing.JTabbedPane();
        projectSplitPane = new javax.swing.JSplitPane();
        designTabbedPane = new javax.swing.JTabbedPane();
        loggerTabbedPane = new javax.swing.JTabbedPane();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProjectMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        settingsMenuItem = new javax.swing.JMenuItem();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Xaven");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/xaven-24x24.png")).getImage());
        addWindowListener(formListener);

        projectToolBar.setFloatable(false);
        projectToolBar.setRollover(true);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        projectToolBar.add(jButton1);

        getContentPane().add(projectToolBar, java.awt.BorderLayout.PAGE_START);

        statusToolBar.setRollover(true);

        jLabel1.setText("Status");
        statusToolBar.add(jLabel1);

        getContentPane().add(statusToolBar, java.awt.BorderLayout.PAGE_END);

        projectPanel.setLayout(new java.awt.BorderLayout());

        baseSplitPane.setOneTouchExpandable(true);

        projectExplorerTabbedPane.setMinimumSize(new java.awt.Dimension(150, 5));
        projectExplorerTabbedPane.setPreferredSize(new java.awt.Dimension(150, 5));
        baseSplitPane.setLeftComponent(projectExplorerTabbedPane);

        projectSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        projectSplitPane.setOneTouchExpandable(true);

        designTabbedPane.setMinimumSize(new java.awt.Dimension(5, 150));
        designTabbedPane.setPreferredSize(new java.awt.Dimension(5, 150));
        projectSplitPane.setTopComponent(designTabbedPane);
        projectSplitPane.setRightComponent(loggerTabbedPane);

        baseSplitPane.setRightComponent(projectSplitPane);

        projectPanel.add(baseSplitPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(projectPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        newProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newProjectMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newprj_wiz.gif"))); // NOI18N
        newProjectMenuItem.setText("New Project");
        newProjectMenuItem.addActionListener(formListener);
        fileMenu.add(newProjectMenuItem);

        mainMenuBar.add(fileMenu);

        jMenu2.setText("Edit");
        mainMenuBar.add(jMenu2);

        jMenu1.setText("Tools");

        settingsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tools.gif"))); // NOI18N
        settingsMenuItem.setText("Settings");
        settingsMenuItem.addActionListener(formListener);
        jMenu1.add(settingsMenuItem);

        mainMenuBar.add(jMenu1);

        setJMenuBar(mainMenuBar);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.WindowListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == settingsMenuItem) {
                XavenFrame.this.settingsMenuItemActionPerformed(evt);
            }
            else if (evt.getSource() == newProjectMenuItem) {
                XavenFrame.this.newProjectMenuItemActionPerformed(evt);
            }
        }

        public void windowActivated(java.awt.event.WindowEvent evt) {
        }

        public void windowClosed(java.awt.event.WindowEvent evt) {
            if (evt.getSource() == XavenFrame.this) {
                XavenFrame.this.formWindowClosed(evt);
            }
        }

        public void windowClosing(java.awt.event.WindowEvent evt) {
            if (evt.getSource() == XavenFrame.this) {
                XavenFrame.this.formWindowClosing(evt);
            }
        }

        public void windowDeactivated(java.awt.event.WindowEvent evt) {
        }

        public void windowDeiconified(java.awt.event.WindowEvent evt) {
        }

        public void windowIconified(java.awt.event.WindowEvent evt) {
        }

        public void windowOpened(java.awt.event.WindowEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

	private void settingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMenuItemActionPerformed
		
	}//GEN-LAST:event_settingsMenuItemActionPerformed

	private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
		// TODO minimize to tray
	}//GEN-LAST:event_formWindowClosed

	private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		// TODO minimize to tray
	}//GEN-LAST:event_formWindowClosing

	private void newProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectMenuItemActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_newProjectMenuItemActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the Nimbus look and feel
		 */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(XavenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(XavenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(XavenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(XavenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new XavenFrame().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane baseSplitPane;
    private javax.swing.JTabbedPane designTabbedPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JTabbedPane loggerTabbedPane;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem newProjectMenuItem;
    private javax.swing.JTabbedPane projectExplorerTabbedPane;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JSplitPane projectSplitPane;
    private javax.swing.JToolBar projectToolBar;
    private javax.swing.JMenuItem settingsMenuItem;
    private javax.swing.JToolBar statusToolBar;
    // End of variables declaration//GEN-END:variables
}
