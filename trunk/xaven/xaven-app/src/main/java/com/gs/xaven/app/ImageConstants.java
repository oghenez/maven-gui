/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gs.xaven.app;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Sabuj Das | sabuj.das@gmail.com
 */
public final class ImageConstants {
	
	public static final String IMG_ROOT_PROJECT = "IMG_ROOT_PROJECT";
	
	private Map<String, ImageIcon> imageIconMap;
			
	private static ImageConstants instance;
	private ImageConstants(){
		init();
	}

	public static ImageConstants getInstance() {
		synchronized(ImageConstants.class){
			if(null == instance)
				instance = new ImageConstants();
		}
		return instance;
	}

	private void init() {
		imageIconMap = new HashMap<String, ImageIcon>();
	}
	
	public void reload(){
		init();
		
	}
	
	public ImageIcon getImageIcon(String key){
		return imageIconMap.get(key);
	}

}
