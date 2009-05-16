package com.mui.logger;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class MavenProgressMonitor {

	
	private JProgressBar progressBar = null;
	private JLabel messageLabel = null;
	
	private long maxValue = 0;
	private long currentValue = 0;
	private boolean isDeterminent = true;
	
	public MavenProgressMonitor(JProgressBar bar, JLabel l) {
		progressBar = bar;
		messageLabel = l;
		if(!isDeterminent){
			progressBar.setIndeterminate(true);
		}else{
			progressBar.setIndeterminate(false);
		}
		progressBar.setMaximum(0);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		messageLabel.setText( "");
	}
	
	
	public void showMessage(String msg){
		messageLabel.setText(msg);
		messageLabel.updateUI();
	}
	
	public void showProgress(int current){
		showProgress(-1 ,current);
	}
	
	public void showProgress(long max, long current){
		if(max == -1){
			isDeterminent = false;
			progressBar.setIndeterminate(true);
			progressBar.setString("" + current);
		}else{
			isDeterminent = true;
			progressBar.setIndeterminate(false);
			int percent = (int)(((double)current / (double)max) * 100.00);
			progressBar.setMaximum(100);
			progressBar.setValue(percent);
			progressBar.setString("" + percent + " %");
		}
		//progressBar.updateUI();
	}
	
	
	
}
