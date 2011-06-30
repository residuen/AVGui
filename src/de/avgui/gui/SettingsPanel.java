package de.avgui.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.avgui.model.AVConstants;

public class SettingsPanel extends JPanel {
	
	public SettingsPanel() {
		initPanel();
	}

	private void initPanel() {
		JLabel label = new JLabel("Settings-Panel", JLabel.LEFT);
		label.setBorder(new EmptyBorder(5, 5, 5, 5));
		label.setFont(new Font("Serif", Font.BOLD, 20));
		setBackground(Color.WHITE);
		add(label);

	}
}
