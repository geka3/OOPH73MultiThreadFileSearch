package net.ukr.geka3;

import java.io.File;

public class SearchFile implements Runnable {
	
	File file = null;
	File [] arrayFile = null;
	Thread th = null;
	String iSearch = null;
	
	public SearchFile(File file,String iSearch) {
		// TODO Auto-generated constructor stub
		
		this.file = file;
		this.arrayFile = this.file.listFiles();
		this.th = new Thread(this);
		this.iSearch = iSearch;
		th.start();
		
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < arrayFile.length; i++) {
			if(arrayFile[i].isDirectory()){
				new SearchFile(arrayFile[i],iSearch);
			} else if(arrayFile[i].isFile() && arrayFile[i].getName().equals(iSearch)){
				System.out.println("i found it at " + arrayFile[i].getAbsoluteFile() + "\\" + arrayFile[i].getName());
			}
			
		}
	}
	
}
