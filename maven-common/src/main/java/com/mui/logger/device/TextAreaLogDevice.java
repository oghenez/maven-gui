package com.mui.logger.device;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

import com.mui.log4j.FlexibleLayout;

public class TextAreaLogDevice extends WriterAppender{

	private static JTextArea outputTextArea = null;

	public TextAreaLogDevice(JTextArea textArea) {
		outputTextArea = textArea;
		this.layout = new FlexibleLayout();
	}
	
	@Override
	public void append(LoggingEvent event) {
		final String message = this.layout.format(event);
		// Append formatted message to textarea using the Swing Thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				outputTextArea.append(message);
			}
		});
	}
	
}
