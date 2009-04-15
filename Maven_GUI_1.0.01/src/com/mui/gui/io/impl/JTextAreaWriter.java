/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.io.impl.JTextAreaWriter.java
 * Date		:	Dec 19, 2008 __ 2:17:55 PM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.gui.io.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

import javax.swing.JTextArea;

/**
 * @author sabuj.das
 *
 */
public class JTextAreaWriter extends Writer implements Serializable{

	private boolean closed = false;
	private JTextArea textArea;
	private StringBuffer buffer;
	
	public JTextAreaWriter(JTextArea textArea) {
		this.setTextArea(textArea);
	}

	public void close() throws IOException {
		closed = true;
	}

	public void flush() throws IOException {
		if(closed){
			throw new IOException("The stream is not open.");
		}
		appendInTextArea();
		buffer = null;
	}
	
	public void write(char[] charArray) throws IOException{
        write(charArray, 0, charArray.length);
    }

	public void write(char[] charArray, int offset, int length) throws IOException{
		if(closed){
			throw new IOException("The stream is not open.");
		}
		getBuffer().append(charArray, offset, length);
	}

	public void write(int c) throws IOException{
		if(closed){
			throw new IOException("The stream is not open.");
		}
		getBuffer().append((char)c);
	}
	
	public void write(String s) throws IOException{
		if(closed){
			throw new IOException("The stream is not open.");
		}
		getBuffer().append(s);
	}
	
	public void write(String string, int offset, int length) throws IOException{
		if(closed){
			throw new IOException("The stream is not open.");
		}
		getBuffer().append(string.substring(offset, length));
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		if(textArea == null){
			throw new IllegalArgumentException("The text area must not be null.");
		}
		this.textArea = textArea;
	}

	public StringBuffer getBuffer() {
		if (buffer == null) {
			buffer = new StringBuffer();
		}
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public void writeString(String s){
		try {
			write(s);
			flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void println(String s){
		try {
			write(s+"\n");
			flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void print(String s){
		try {
			write(s);
			flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void appendInTextArea(){
		textArea.append(getBuffer().toString());
		if(System.getProperty("java.version").startsWith("1.1")){
			  textArea.append("\n");
		}
		textArea.setCaretPosition(textArea.getDocument().getLength());
		
	}
}
