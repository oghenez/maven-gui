/**
 * 		Maven GUI
 * --------------------------------------------------------------------
 * File		:	org.apache.maven.mui.cmd.CommandLineCreator.java
 * Date		:	Dec 15, 2008 __ 3:31:19 PM
 * Author	:	sabuj.das
 * --------------------------------------------------------------------
 */
package com.mui.core.cmd;

import java.util.List;

/**
 * @author sabuj.das
 *
 */
public class CommandLineCreator implements CommandLineConstants{

	private StringBuffer commandLine;
	private List<String> commandLineArguments;
	
	public CommandLineCreator() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCommand(String command){
		
	}
	
	public void addCommandLineArguments(List<String> args){
		
	}
	
	public String updateCommandLine(String commandLine, String command, boolean add){
		if(commandLine == null)
			commandLine = "";
		if(commandLine.length() == 0){
			if(add)
				commandLine = command;
		}else{
			if(! commandLine.contains(command)){
				if(add){
					commandLine += CMD_SEPARATOR + command;
				}
			}else{
				if(!add){
					commandLine = commandLine.replaceAll(command, "");
				}
			}
		}
		return commandLine;
	}
	
	public String getFullCommand(){
		return "";
	}

	public StringBuffer getCommandLine() {
		return commandLine;
	}

	public void setCommandLine(StringBuffer commandLine) {
		this.commandLine = commandLine;
	}

	public List<String> getCommandLineArguments() {
		return commandLineArguments;
	}

	public void setCommandLineArguments(List<String> commandLineArguments) {
		this.commandLineArguments = commandLineArguments;
	}
	
	
	
}
