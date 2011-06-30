package de.avgui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import de.avgui.gui.About;
import de.avgui.gui.ContentPanel;
import de.avgui.interfaces.Views;

public class IconMenuListener implements ActionListener {
	
	private String selectedFolder = "";

//	private ComponentMap componentMap = null;
	private Views contentPanel;

	public IconMenuListener(ContentPanel contentPanel) //ComponentMap componentMap)
	{
//		this.componentMap = componentMap;

//		selectedFolder = TEST_FOLDER;
		
		this.contentPanel = contentPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String cmd = ((Component) arg0.getSource()).getName();

		System.out.println("cmd=" + cmd + " selectedFolder=" + selectedFolder);
		
		if(cmd.equals("about"))
			new About();
		else
			doAction(cmd);
				
	}
	
	private void doAction(String cmd) {
		
		if(cmd.equals("fullscan"))
			contentPanel.switchView(ContentPanel.SCAN_VIEW);
		else
			if(cmd.equals("fractscan"))
				contentPanel.switchView(ContentPanel.FRACTIONAL_VIEW);
			else
				contentPanel.switchView(ContentPanel.SETTINGS_VIEW);
			
	}
}
