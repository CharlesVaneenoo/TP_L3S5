package main;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {
	
	@Override
	public boolean accept(File arg0, String arg1) {
		return arg0.toString().endsWith(arg1);
	}
}
