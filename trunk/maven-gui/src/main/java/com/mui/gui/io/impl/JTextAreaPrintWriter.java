/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.io.impl.JTextAreaPrintWriter.java
 * Date		:	Dec 19, 2008 __ 4:10:43 PM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.io.impl;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author sabuj.das
 *
 */
public class JTextAreaPrintWriter extends PrintWriter {

	/**
	 * @param out
	 */
	public JTextAreaPrintWriter(Writer out) {
		super(out);
	}

	

}
