package de.avgui.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.avgui.model.ScanData;

public class ScanResultPanel extends JPanel {
	
	private DefaultListModel model = new DefaultListModel();
	private JList list = new JList(model);
	
	public ScanResultPanel() {
		initPanel();
	}

	private void initPanel() {
		
		setLayout(new GridLayout(1,1)); // new BorderLayout());
		
		setBackground(Color.WHITE);
		
		setBorder(BorderFactory.createTitledBorder("List of suspect files"));
		
		add(new JScrollPane(list));
	}
	
	public void updateView(ScanData scanData) {
		
		if(scanData.getInfectionList().size() > model.getSize())
			model.addElement(scanData.getInfectionList().get(scanData.getInfectionList().size() - 1));
	}
	
	public void clearList() {
		
		model.clear();
	}
}
