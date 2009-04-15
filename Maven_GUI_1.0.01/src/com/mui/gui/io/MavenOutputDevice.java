/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.io.MavenOutputDevice.java
 * Date		:	Dec 19, 2008 __ 2:02:37 PM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.io;

import java.io.OutputStream;
import java.io.Writer;

/**
 * @author sabuj.das
 *
 */
public interface MavenOutputDevice {
	
	public void println(Writer writer, String message);
	
}
