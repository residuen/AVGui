package de.avgui.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import de.avgui.gui.About;
import de.avgui.gui.ContentPanel;

public class IconMenuListener implements ActionListener {
	
//	private String TEST_FOLDER = "/skole/tjener/home0/";

	private String selectedFolder = "";

//	private ComponentMap componentMap = null;
	private ContentPanel contentPanel;

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
		
		if(cmd.equals("fullscan") || cmd.equals("fractscan"))
			contentPanel.switchView(ContentPanel.SCAN_VIEW);
		else
			contentPanel.switchView(ContentPanel.SETTINGS_VIEW);
			
	}
}
