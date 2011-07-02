package de.avgui.test;

import java.io.File;

import de.avgui.gui.FullScanPanel;
import de.avgui.model.ScanData;

public class TestScanner extends Thread {
	
	private ScanData scanData = null;
	private FullScanPanel scanPanel = null;
	
	private boolean scanning = true;
	
	int rand;
	
	public TestScanner(ScanData scanData, FullScanPanel scanPanel) {
		
		this.scanData = scanData;
		this.scanPanel = scanPanel;
	}
	
	public void run() {
		
		scanData.setStartTime(System.currentTimeMillis());
		
		File file = new File("/");
		
		while(scanning) {
			
			showFiles(file.listFiles());
			
			if(!scanning)
				break;
		}
	}
	
	private void showFiles(File[] files) {
		
		if(files != null && scanning)
		{
			for(File file : files) {
			
				if(scanning)
					if(file.isFile())
					{
						rand = ((int)(Math.random()*100));
						
						scanData.setCurrentTime(System.currentTimeMillis());
						scanData.setElementName(file.getAbsolutePath());
						scanData.setScannedElements(scanData.getScannedElements() + 1);
						scanData.setScanTyp("Full scan");
						
						scanPanel.updateScanInfo(scanData);
						
						if(rand==1)
						{
							scanData.addInfectedFile(scanData.getElementName());
							System.out.println(scanData.getElementName()+" is a suspect file!");
						}
							
					}
					else
						showFiles(file.listFiles());
				
				try { Thread.sleep(50); }
				catch (InterruptedException e) { e.printStackTrace(); scanning = false; break;  }
			}
		}
	}
	
	public ScanData getScanData() {
		return scanData;
	}

	public void interrupt()
	{
		scanning = false;
	}
}
