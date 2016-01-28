package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PluginFinder implements ActionListener {

	protected File dir;
	protected List<File> currentFiles;
	protected PluginFilter filter = new PluginFilter();

	public PluginFinder(File dir) {
		this.dir = dir;
		this.currentFiles = new ArrayList<File>();
		this.listFiles();
	}

	public List<File> getCurrentFiles(){
		return currentFiles;
	}

	public File getDir(){
		return this.dir;
	}
	
	public List<File> listFiles(){
		File[] files = dir.listFiles();
		for (File f : files){
			if (filter.accept(f,".class"))
				currentFiles.add(f);
		}	
		return currentFiles;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			File[] files = dir.listFiles();
			PluginAddedLogger eventPlug = new PluginAddedLogger();
				for (File f : files){
					if (filter.accept(f,".class") && !currentFiles.contains(f)){
						currentFiles.add(f);	
						eventPlug.addingFile();
					}
				}
				if (files.length<currentFiles.size()){
					eventPlug.removingFile();
					currentFiles.remove(currentFiles.get(currentFiles.size()-1));
				}		
	}
	
	public void start(){
		Timer timer = new Timer(1000,this);
		timer.start();
		while(true);
	}
	
	 public static void main(String[] args){
		 File dir = new File("./classes/plugins");
		 PluginFinder plug = new PluginFinder(dir); 
	
		 plug.start();
	 }

}