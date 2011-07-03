package de.avgui.tools;

import java.awt.Component;
import java.awt.Dimension;

public class ComponentTools {
	
	public static void dimButton(Component button) {
		
		button.setPreferredSize(new Dimension(110, 25));
		button.setMinimumSize(new Dimension(110, 25));
		button.setMaximumSize(new Dimension(110, 25));
	}

}
