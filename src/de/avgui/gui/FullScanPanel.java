package de.avgui.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import de.avgui.interfaces.Views;
import de.avgui.model.AVConstants;
import de.avgui.model.ScanData;
import de.avgui.test.TestScanner;
import de.avgui.tools.ComponentTools;

public class FullScanPanel extends JPanel implements Views, ActionListener {
	
	private final String[] toogle = new String[] { "Start scan!", "Stop scan!" };
	
	private ScanData scanData = null;
	
	private JLabel scanTyp =  new JLabel("");
	private JLabel startTime =  new JLabel("");
	private JLabel currentTime =  new JLabel("");
	private JLabel scannedElements =  new JLabel("");
	private JLabel elementName =  new JLabel("");
	private JLabel suspectFiles =  new JLabel("");
	
	private JRadioButton delete = new JRadioButton("Delete");
	private JRadioButton move = new JRadioButton("Move to quarantine");
	private JRadioButton rename = new JRadioButton("Rename");
	private JRadioButton doNothing = new JRadioButton("Do nothing");
	
	private ScanResultPanel ScanResultPanel = new ScanResultPanel();
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private Date time = new Date();
	
	private TestScanner scanner = null;
	
	public FullScanPanel() {
		
		initPanel();
	}

	private void initPanel() {
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		int strutSize = 10;
		
		Box hBox = Box.createHorizontalBox();
		
		Box vBox = Box.createVerticalBox();
		vBox.setBackground(Color.WHITE);
		
		ButtonGroup bGroup = new ButtonGroup();
		
		JToggleButton startStop = new JToggleButton(toogle[0]);
		
		JPanel headlinePanel = new JPanel(new BorderLayout());
		JPanel scanTypPanel = new JPanel(new BorderLayout());
		JPanel startTimePanel = new JPanel(new BorderLayout());
		JPanel currentTimePanel = new JPanel(new BorderLayout());
		JPanel scannedElementsPanel = new JPanel(new BorderLayout());
		JPanel elementNamePanel = new JPanel(new BorderLayout());
		JPanel suspectFilesPanel = new JPanel(new BorderLayout());
		JPanel totoPanel = new JPanel(new FlowLayout());
		
		JLabel scanTypText =  new JLabel(" Scantyp: ");
		JLabel startTimeText =  new JLabel(" Starttime: ");
		JLabel currentTimeText =  new JLabel(" Time left: ");
		JLabel scannedElementsText =  new JLabel(" Scanned elements: ");
		JLabel elementNameText =  new JLabel(" Element name: ");
		JLabel suspectFilesText =  new JLabel(" Suspect files: ");

		coloringLabel(scanTypText);
		resizingLabel(scanTypText);
		coloringLabel(startTimeText);
		resizingLabel(startTimeText);
		coloringLabel(currentTimeText);
		resizingLabel(currentTimeText);
		coloringLabel(scannedElementsText);
		resizingLabel(scannedElementsText);
		coloringLabel(elementNameText);
		resizingLabel(elementNameText);
		coloringLabel(suspectFilesText);
		resizingLabel(suspectFilesText);

		coloringLabel(scanTyp);
		coloringLabel(startTime);
		coloringLabel(currentTime);
		coloringLabel(scannedElements);
		coloringLabel(elementName);
		coloringLabel(suspectFiles);
		
		startStop.setName("startstop");
		startStop.addActionListener(this);
		ComponentTools.dimButton((Component)startStop);
		
		JLabel label = new JLabel("Scanning the system ... ", new ImageIcon(getClass().getResource("/de/avgui/images/icons/system-search.png")), JLabel.LEFT);
		coloringLabel(label);
		label.setBorder(new EmptyBorder(5, 5, 5, 5));
		label.setFont(new Font("Serif", Font.BOLD, 18));
		hBox.add(label);
		hBox.add(startStop);
		headlinePanel.setBackground(Color.WHITE);
		headlinePanel.add(hBox, BorderLayout.WEST);
		vBox.add(headlinePanel);		
		vBox.add(Box.createVerticalStrut(strutSize));

		scanTypPanel.add(scanTypText, BorderLayout.WEST);
		scanTypPanel.add(scanTyp, BorderLayout.CENTER);
		vBox.add(scanTypPanel);		
		vBox.add(Box.createVerticalStrut(strutSize));

		startTimePanel.add(startTimeText, BorderLayout.WEST);
		startTimePanel.add(startTime, BorderLayout.CENTER);
		vBox.add(startTimePanel);		
		vBox.add(Box.createVerticalStrut(strutSize));

		currentTimePanel.add(currentTimeText, BorderLayout.WEST);
		currentTimePanel.add(currentTime, BorderLayout.CENTER);
		vBox.add(currentTimePanel);		
		vBox.add(Box.createVerticalStrut(strutSize));

		scannedElementsPanel.add(scannedElementsText, BorderLayout.WEST);
		scannedElementsPanel.add(scannedElements, BorderLayout.CENTER);
		vBox.add(scannedElementsPanel);		
		vBox.add(Box.createVerticalStrut(strutSize));

		elementNamePanel.add(elementNameText, BorderLayout.WEST);
		elementNamePanel.add(elementName, BorderLayout.CENTER);
		vBox.add(elementNamePanel);		
		vBox.add(Box.createVerticalStrut(strutSize));

		suspectFilesPanel.add(suspectFilesText, BorderLayout.WEST);
		suspectFilesPanel.add(suspectFiles, BorderLayout.CENTER);
		vBox.add(suspectFilesPanel);
		vBox.add(Box.createVerticalStrut(strutSize));

		vBox.add(ScanResultPanel);
		vBox.add(Box.createVerticalStrut(strutSize));
		delete.setBackground(Color.WHITE);
		move.setBackground(Color.WHITE);
		rename.setBackground(Color.WHITE);
		doNothing.setBackground(Color.WHITE);
		
		totoPanel.setBackground(Color.WHITE);

		bGroup.add(delete);
		bGroup.add(move);
		bGroup.add(rename);
		bGroup.add(doNothing);
		
		totoPanel.add(delete);
		totoPanel.add(move);
		totoPanel.add(rename);
		totoPanel.add(doNothing);
		totoPanel.add(new JButton("OK"));
		
		vBox.add(totoPanel);
		
		add(vBox, BorderLayout.NORTH);

	}
	
	private void coloringLabel(JLabel label) {
		
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
	}
	
	private void resizingLabel(JLabel label) {
		
		label.setPreferredSize(new Dimension(120, 20));
	}

	public void updateScanInfo(ScanData scanData) {
		
		scanTyp.setText(scanData.getScanTyp());
		currentTime.setText(""+dateFormat.format(scanData.getCurrentTime() - scanData.getStartTime() - 3600000));
		scannedElements.setText(""+scanData.getScannedElements());
		elementName.setText(""+scanData.getElementName());
		suspectFiles.setText(""+scanData.getInfectionList().size());
		
		ScanResultPanel.updateView(scanData);
	}
	
	public void switchView(int view) { }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(((Component)arg0.getSource()).getName().equals("startstop"));
		{
			if(scanner == null)
			{
				if(((JToggleButton)arg0.getSource()).isSelected())
				{
					scanner = new TestScanner(new ScanData(), this);
				
					time.setTime(scanner.getScanData().getStartTime());
					startTime.setText(""+dateFormat.format(scanner.getScanData().getStartTime()));
					
					((JToggleButton)arg0.getSource()).setText(toogle[1]);
	
					scanner.start();
				}
			}
			else
			{
				((JToggleButton)arg0.getSource()).setText(toogle[0]);
				
				scanner.interrupt();
				scanner = null;
				
				ScanResultPanel.clearList();
			}
		}
	}
}
