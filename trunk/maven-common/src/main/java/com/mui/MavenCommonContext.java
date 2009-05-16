package com.mui;

import com.mui.logger.TextAreaLogAppender;




public class MavenCommonContext {

	
	public TextAreaLogAppender textAreaLogAppender;
		
	
	
	private static MavenCommonContext instance;
	
	private MavenCommonContext(){}
	
	public static MavenCommonContext getInstance() {
		if(instance == null){
			instance = new MavenCommonContext();
		}
		return instance;
	}
	
	
}
