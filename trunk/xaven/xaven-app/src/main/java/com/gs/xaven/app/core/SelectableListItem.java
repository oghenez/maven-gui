/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gs.xaven.app.core;

/**
 *
 * @author Sabuj Das | sabuj.das@gmail.com
 */
public abstract class SelectableListItem {

	private String text;
	private boolean selected = false;
	private Object value;

	public SelectableListItem() {
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getText();
	}
	
	
}
