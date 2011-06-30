package de.avgui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.avgui.listener.IconMenuListener;

public class IconMenuPanel extends JPanel {

	public IconMenuPanel(ContentPanel contentPanel)
	{
		initPanel(contentPanel);
	}

	private void initPanel(ContentPanel contentPanel)
	{
		setBackground(new Color(215, 215, 215));
		
		IconMenuListener iconMenuListener = new IconMenuListener(contentPanel); //componentMap);
		Box vBox = Box.createVerticalBox();
		Dimension dim = new Dimension(100, 80);
		JPanel panel = null;
		Font font = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12);

		panel = new JPanel(new GridLayout(1, 1));
		JButton button = new JButton("<html>full<br/>scan</html>",
				new ImageIcon(getClass().getResource("/de/avgui/images/icons/drive-harddisk.png")));
		button.setFont(font);
		button.setToolTipText("Perform a full system scan");
		button.setName("fullscan");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		button.addActionListener(iconMenuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(5));
		
		panel = new JPanel(new GridLayout(1, 1));
		button = new JButton("<html>fractional<br/>scan</html>",
				new ImageIcon(getClass().getResource("/de/avgui/images/icons/system-search.png")));
		button.setFont(font);
		button.setToolTipText("Select the conditions for a fractional scan");
		button.setName("fractscan");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		button.addActionListener(iconMenuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(5));
		
		panel = new JPanel(new GridLayout(1, 1));
		button = new JButton("<html>edit<br/>settings</html>",
				new ImageIcon(getClass().getResource("/de/avgui/images/icons/preferences-system.png")));
		button.setFont(font);
		button.setToolTipText("<html>Dem System zugeh&ouml;rige PC's verwalten</html>");
		button.setName("edit");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		button.addActionListener(iconMenuListener);
		panel.add(button);
		vBox.add(panel);
		vBox.add(Box.createVerticalStrut(5));

		panel = new JPanel(new GridLayout(1, 1));
		button = new JButton("<html>About</html>",
				new ImageIcon(getClass().getResource("/de/avgui/images/icons/help-browser.png")));
		button.setFont(font);
		button.setToolTipText("<html>Infos &uuml;ber AVGui</html>");
		button.setName("about");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setPreferredSize(dim);
		button.setMinimumSize(dim);
		button.addActionListener(iconMenuListener);
		panel.add(button);
		vBox.add(panel);

		add(vBox);
	}
}
