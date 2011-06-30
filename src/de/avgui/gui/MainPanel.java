package de.avgui.gui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainPanel extends JPanel
{
	public MainPanel()
	{
		super(new BorderLayout());
		
		initPanel();
	}
	
	public MainPanel(LayoutManager arg0)
	{
		super(new BorderLayout());

		initPanel();
	}

	private void initPanel()
	{
		System.out.println("initPanel");
		
		ContentPanel contentPanel = new ContentPanel();
		
		JScrollPane leftScrollpane = new JScrollPane(new IconMenuPanel(contentPanel));
		leftScrollpane.setBorder(null);

		add(new TopPanel(), BorderLayout.NORTH);
		add(leftScrollpane, BorderLayout.WEST);
		add(contentPanel, BorderLayout.CENTER);
	}
}
