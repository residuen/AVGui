package de.avgui.gui;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	public MainFrame(String arg0)
	{
		super(arg0);

		initFrame();
	}

	private void initFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(680, 560);
	}

}
