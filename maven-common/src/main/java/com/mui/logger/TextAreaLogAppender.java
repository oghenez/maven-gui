package com.mui.logger;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

import com.mui.log4j.FlexibleLayout;

public class TextAreaLogAppender extends WriterAppender{

	private static JTextArea outputTextArea = null;
	private static TextAreaLogWorker worker;
	public TextAreaLogAppender(JTextArea textArea) {
		outputTextArea = textArea;
		this.layout = new FlexibleLayout();
		worker = new TextAreaLogWorker("", outputTextArea);
	}
	
	public void append(LoggingEvent event) {
		final String message = this.layout.format(event);
		worker = new TextAreaLogWorker(message, outputTextArea);
		worker.execute();
		
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				outputTextArea.append(message);
			}
		});*/
	}
	
}
