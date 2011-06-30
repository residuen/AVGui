package de.avgui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MainMenu extends JMenuBar implements ActionListener {

	public MainMenu() {
		super();

		initMenuBar();
	}

	private void initMenuBar() {
		JMenu help = new JMenu("Help");
		JMenu file = new JMenu("file");

		JMenuItem about = new JMenuItem("About");
		about.addActionListener(this);

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(this);

		file.add(exit);

		help.add(about);

		add(file);
		add(help);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("About"))
			new About();
		else if (arg0.getActionCommand().equals("Exit"))
			System.exit(0);
	}
}
