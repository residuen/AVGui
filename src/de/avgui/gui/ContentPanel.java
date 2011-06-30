package de.avgui.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import de.avgui.interfaces.Views;

public class ContentPanel extends JPanel implements Views {
	
	public final static int SCAN_VIEW = 0;
	public final static int FRACTIONAL_VIEW = 1;
	public final static int SETTINGS_VIEW = 2;
	
	private ScanPanel scanPanel = new ScanPanel();
	private SettingsPanel settingsPanel = new SettingsPanel();
	
	public ContentPanel() {
		
		initPanel();
	}

	private void initPanel() {
		
		setLayout(new GridLayout(1,1));
		
		Box vBox = Box.createVerticalBox();
		
		scanPanel.setVisible(false);
		settingsPanel.setVisible(false);
		
		setBackground(Color.WHITE);
		vBox.add(scanPanel);
		vBox.add(settingsPanel);
		
		add(vBox);

	}
	
	public void switchView(int view)
	{
		if(view==SCAN_VIEW || view == FRACTIONAL_VIEW)
		{
			System.out.println("ContentPanel: Schalter 1 "+" view="+view);
			settingsPanel.setVisible(false);
			
			scanPanel.switchView(view);
			scanPanel.setVisible(true);
		}
		else
		{
			System.out.println("ContentPanel: Schalter 2");
			scanPanel.setVisible(false);
//			scanPanel.switchView(view);
			
			settingsPanel.setVisible(true);
		}
		
		repaint();
	}

}
