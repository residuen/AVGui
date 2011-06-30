package de.avgui.gui;

import java.awt.Color;

import javax.swing.JPanel;

public class ContentPanel extends JPanel {
	
	public final static int SCAN_VIEW = 0;
	public final static int SETTINGS_VIEW = 1;
	
	private ScanPanel scanPanel = new ScanPanel();
	private SettingsPanel settingsPanel = new SettingsPanel();
	
	public ContentPanel() {
		
		initPanel();
	}

	private void initPanel() {
		
//		setLayout(new GridLayout());
		
		scanPanel.setVisible(false);
		settingsPanel.setVisible(false);
		
		setBackground(Color.WHITE);
		add(scanPanel);
		add(settingsPanel);

	}
	
	public void switchView(int viewName)
	{
		if(viewName==SCAN_VIEW)
		{
			System.out.println("Schalter 1");
			settingsPanel.setVisible(false);
			scanPanel.setVisible(true);
		}
		else
		{
			System.out.println("Schalter 2");
			scanPanel.setVisible(false);
			settingsPanel.setVisible(true);
		}
		
		repaint();
	}

}
