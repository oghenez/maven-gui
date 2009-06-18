package com.mui.view;
// http://albertattard.blogspot.com/2008/09/practical-example-of-swing-worker.html
import javax.swing.SwingWorker;

import com.mui.launch.GuiLauncher;

public class MavenTestWorker extends SwingWorker<Integer, String>{

	private final String baseDir;
	private final String[] commandArgs;
	
	public MavenTestWorker() {
		this.baseDir = System.getProperty("user.home");
		this.commandArgs = new String[]{};
	}
	
	public MavenTestWorker(String baseDir, String[] commandArgs) {
		this.baseDir = baseDir;
		this.commandArgs = commandArgs;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		return GuiLauncher.main(commandArgs);
	}
	
	
}
