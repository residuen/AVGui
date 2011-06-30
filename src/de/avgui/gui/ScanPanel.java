package de.avgui.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.avgui.interfaces.Views;
import de.avgui.model.AVConstants;

public class ScanPanel extends JPanel implements Views {
	
	public final static int SCAN_VIEW = 0;
	public final static int FRACTIONAL_VIEW = 1;
	
	private JPanel scanView = new JPanel(new GridLayout(1,1));	
	private JPanel fractionalView = new JPanel(new GridLayout(1,1));
	
	public ScanPanel() {
		initPanel();
	}

	private void initPanel() {
		
		setLayout(new GridLayout(1,1));
		
		Box vBox = Box.createVerticalBox();
		setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Scan- & fractscan panel", JLabel.LEFT);
		label.setBorder(new EmptyBorder(5, 5, 5, 5));
		label.setFont(new Font("Serif", Font.BOLD, 20));
		
		fractionalView.setBorder(BorderFactory.createTitledBorder("Fractional scan-properties"));
		scanView.setBorder(BorderFactory.createTitledBorder("Scanning system"));
		
		vBox.add(label);
		vBox.add(fractionalView);
		vBox.add(scanView);
		
		add(vBox);

	}
	
	public void switchView(int view)
	{
		if(view==SCAN_VIEW)
		{
			System.out.println("Schalter 1");
			fractionalView.setVisible(false);
//			scanView.setVisible(true);
		}
		else
		{
			System.out.println("Schalter 2");
//			scanView.setVisible(false);
			fractionalView.setVisible(true);
		}
		
		repaint();
	}

}
