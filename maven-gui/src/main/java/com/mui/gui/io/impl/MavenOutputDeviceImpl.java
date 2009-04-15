/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.io.impl.MavenOutputDeviceImpl.java
 * Date		:	Dec 19, 2008 __ 2:03:16 PM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.io.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import com.mui.gui.io.MavenOutputDevice;


/**
 * @author sabuj.das
 *
 */
public class MavenOutputDeviceImpl implements MavenOutputDevice {

	private OutputStream defaultOutputStream = System.out;
	
	private Writer defaultWriter = new PrintWriter(System.out); 
	
	public void write(OutputStream outputStream, Object message, boolean append){
		if(outputStream == null){
			outputStream = defaultOutputStream;
		}
		try {
			outputStream.write(message.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void println(Writer writer, String message){
		if(writer == null){
			writer = defaultWriter;
		}
		try {
			writer.append(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
