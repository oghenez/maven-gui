package com.mui.logger;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class TextAreaLogWorker extends SwingWorker<Integer, String>{

	private final String message;
	
	private final JTextArea outputTextArea;
	
	
	
	public TextAreaLogWorker(String message, JTextArea outputTextArea) {
		super();
		this.message = message;
		this.outputTextArea = outputTextArea;
	}



	@Override
	protected Integer doInBackground() throws Exception {
		outputTextArea.append(message);
		return 0;
	}

	

}
