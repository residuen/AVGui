package de.avgui.model;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;

public class AVConstants {

	public static final double version = 0;
	
	public static final String versionText = "v. " + version;
	
	public static void dimButton(Component button) {
		
		button.setPreferredSize(new Dimension(110, 25));
		button.setMinimumSize(new Dimension(110, 25));
		button.setMaximumSize(new Dimension(110, 25));
	}
}
