/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gs.xaven.app.core;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Sabuj Das | sabuj.das@gmail.com
 */
public class RadioButtonListCellRenderer<T extends RadioButtonListItem> extends JRadioButton
		implements ListCellRenderer<T> {

	public Component getListCellRendererComponent(JList<? extends T> list,
			T value, int index, boolean isSelected, boolean cellHasFocus) {
		
		setSelected(value.isSelected());
		setEnabled((index == 0) ? false : list.isEnabled());
		setFont(list.getFont());
		setBackground(list.getBackground());
		setForeground(list.getForeground());
		setText(value.toString());
		value.getButtonGroup().add(this);

		return this;
	}
	
	
}
