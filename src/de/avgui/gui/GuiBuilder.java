package de.avgui.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GuiBuilder {
	
	public GuiBuilder()
	{
		initLookAndFeel();
		
		MainFrame mainFrame = new MainFrame("AVGui: A Linux-GUI for antivir-tools");
		
		MainPanel mainPanel = new MainPanel();
		
//		MainMenu mainMenu = new MainMenu();
		
//		mainFrame.setJMenuBar(mainMenu);
//
		mainFrame.getContentPane().add(mainPanel);
//
		mainFrame.setVisible(true);
	}

	private void initLookAndFeel() {
		// Setzen des Look & Feels auf die System-Optik
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
