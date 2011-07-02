package de.avgui.model;

import java.util.ArrayList;

public class ScanData {
	
	private String scanTyp = "Full scan";
	private String elementName = null;

	private long startTime = System.currentTimeMillis();
	private long currentTime = startTime;
	
	private int scannedElements = 0;
	
	private ArrayList<String> infectionList = new ArrayList<String>();
	
	public String getScanTyp() {
		return scanTyp;
	}

	public void setScanTyp(String scanTyp) {
		this.scanTyp = scanTyp;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	public int getScannedElements() {
		return scannedElements;
	}

	public void setScannedElements(int scannedElements) {
		this.scannedElements = scannedElements;
	}
	
	public ArrayList<String> getInfectionList() {
		return infectionList;
	}

	public void reset() {
		
		scanTyp = "Full scan";
		elementName = null;

		startTime = System.currentTimeMillis();
		currentTime = startTime;
		
		scannedElements = 0;
	}
	
	public void addInfectedFile(String name) {
		
		infectionList.add(name);
	}
}
