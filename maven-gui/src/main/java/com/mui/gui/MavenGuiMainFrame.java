/**
 * GUI tool for Maven
 * 
 * File		: com.mui.gui.MavenGuiMainFrame.java
 * Type		: com.mui.gui.MavenGuiMainFrame
 * 
 * Date		: Apr 8, 2009	11:06:00 AM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.mui.MavenGUIContext;
import com.mui.MavenGuiConstants;
import com.mui.gui.comp.MavenMenuBar;
import com.mui.gui.event.MavenGUIActionListener;
import com.mui.gui.panels.MainPanel;

/**
 * @author sabuj.das
 *
 */
public class MavenGuiMainFrame extends JFrame 
	implements MavenGuiConstants, 
		ActionListener, WindowListener
{

	private static MavenGUIContext context = MavenGUIContext.getInstance();
	
	private MavenMenuBar mavenMenuBar;
	
	private Container container;
	private MainPanel motherPanel;
	
	public MavenGuiMainFrame() {
		setFrameProperties();
		initComponents();
		
		addWindowListener(this);
	}

	private void setFrameProperties() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension resolution = tk.getScreenSize();
		Point location = new Point();
		Dimension dimension = new Dimension();
		
		setTitle("Maven - GUI");
		
		if(context.getFrameLocation() != null){
			location = context.getFrameLocation();
		}else{
			location.x = resolution.width / 8;
			location.y = resolution.height / 8;
			context.setFrameLocation(location);
		}
		
		if(context.getFrameSize() != null){
			dimension = context.getFrameSize();
		}else{
			dimension.width = (3 * resolution.width) / 4;
			dimension.height = (3 * resolution.height) / 4;
			context.setFrameSize(dimension);
		}
		setLocation(location);
		setSize(dimension);
		
		ImageIcon icon = new ImageIcon(
				IMAGE_PATH + "icon_009.PNG"//"apache_16x16.gif"
			);
		setIconImage(icon.getImage());
	}
	
	
	private void initComponents(){
		container = getContentPane();
		container.setLayout(new BorderLayout());
		mavenMenuBar = new MavenMenuBar(this);
		
		setJMenuBar(mavenMenuBar);
		
		motherPanel = new MainPanel();
		
		container.add(motherPanel, BorderLayout.CENTER);
		
		
	}


	public void actionPerformed(ActionEvent event) {
		new MavenGUIActionListener().handelEvent(event);
	}


	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void windowClosed(WindowEvent e) {
		
	}


	public void windowClosing(WindowEvent e) {
		context.setFrameLocation(getLocation());
		context.setFrameSize(getSize());
		File contextFile = new File(MavenGuiConstants.CONTEXT_FILE_NAME + "maven_context.ctx");
		ObjectOutputStream os = null;
		try {
			contextFile.createNewFile();
			os = new ObjectOutputStream(new FileOutputStream(contextFile));
			os.writeObject(context);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		System.exit(0);
	}


	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
