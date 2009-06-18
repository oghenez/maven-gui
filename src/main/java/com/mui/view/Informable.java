package com.mui.view;

public interface Informable {

	void messageChanged(String message);
	
	void progressChanged(int currentValue, int totalValue);
	
}
