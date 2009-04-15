/**
 * GUI tool for Maven
 * 
 * File		: com.mui.MavenGuiConstants.java
 * Type		: com.mui.MavenGuiConstants
 * 
 * Date		: Apr 8, 2009	11:39:49 AM
 *
 * Author	: Sabuj Das
 *
 */
package com.mui;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

/**
 * @author sabuj.das
 * 
 */
public interface MavenGuiConstants {

	String CONTEXT_FILE_NAME = MavenGuiConstants.class
			.getResource("/com/mui/").getPath().toString();
	
	String PROPERTIES_FILE_NAME = MavenGuiConstants.class
        .getResource("/").getPath().toString();
	
	String NA = "NA";

	URL IMAGE_LOCATION_URL = MavenGuiConstants.class
			.getResource("/com/mui/gui/images/");
	String IMAGE_PATH = IMAGE_LOCATION_URL.getPath().toString();

	// Action commands
	String EXIT_CMD = "EXIT_CMD";
	String CREATE_PROJECT_CMD = "CREATE_PROJECT_CMD";
	String DEPENDENCY_BROWSER_CMD = "DEPENDENCY_BROWSER_CMD";

	// Plugind
	String _PLUGIN = "";
	String ARCHETYPE_CREATE_PLUGIN = "Archetype : Create";
	String ARCHETYPE_GENERATE_PLUGIN = "Archetype : Generate";
	String ARCHETYPE_CREATE_FROM_PROJECT_PLUGIN = "Archetype : Create from Project";
	String ARCHETYPE_CRAWL_PLUGIN = "Archetype : Crawl";

	/*
	 * Colors
	 */
	Color MENU_BAR_BG = new Color(195, 218, 249);
	Color MENU_BAR_FG = Color.BLACK;

	Color PANEL_HEADER_BG = new Color(48, 97, 182);
	Color PANEL_HEADER_FG = Color.WHITE;

	Color PANEL_BG = new Color(178, 204, 247);
	Color PANEL_FG = Color.BLACK;

	Color SELECTED_TAB_BG = new Color(239, 169, 62);
	Color SELECTED_TAB_FG = Color.BLACK;

	Color PASSWORD_ECHO_COLOR = Color.BLUE;

	Color ERROR_TEXT_FG = Color.RED;
	Color HEARED_TEXT_FG = Color.WHITE;

	Color STRONG_PWD_BG = Color.GREEN;
	Color GOOD_PWD_BG = Color.YELLOW;
	Color BAD_PWD_BG = Color.RED;
	Color DEFAULT_PWD_BG = PANEL_BG;

	Color WARNING_MESSAGE_FG = Color.YELLOW;

	Color SUCCESS_MESSAGE_FG = Color.GREEN;
	/* -------------------------------------------------- */

	Font HEADER_TXET_FONT = new Font("Serif", Font.BOLD, 18);

	char PASSWORD_ECHO_CHAR = '\u2666';

	String IMAGE_RESOURCE_PATH = "/images/";

	String STAR_LABEL_TEXT = "<html>" + "<head>" + "<style type=\"text/css\">"
			+ "<!--" + ".style1 {color: #FF0000}" + "-->" + "</style>"
			+ "</head>" + "<body>" + "<span class=\"style1\">" + "*"
			+ "</span>" + "</body>" + "</html>";

	char ACCEPTED_FIELD_CHAR = '\u221A';
	Color ACCEPTED_FIELD_FG = Color.GREEN;
	char REJECTED_FIELD_CHAR = '\u00D7';
	Color REJECTED_FIELD_FG = Color.RED;

	// Constants for main menu panel
	String PERSONAL_INFO_MENU_BUTTON_TXT = "Personal Info";
	String ADDRESS_BOOK_MENU_BUTTON_TXT = "Address Book";
	String PHONE_BOOK_MENU_BUTTON_TXT = "Phone Book";
	String CALENDAR_MENU_BUTTON_TXT = "Calendar";
	String MAIL_MENU_BUTTON_TXT = "Mails";
	String EXTRAS_MENU_BUTTON_TXT = "Extras";

	Color MENU_PANEL_BUTTON_BG = PANEL_HEADER_BG;
	Color MENU_PANEL_BUTTON_FG = PANEL_HEADER_FG;
}
