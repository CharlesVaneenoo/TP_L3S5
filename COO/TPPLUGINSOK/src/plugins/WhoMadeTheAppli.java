package plugins;

import main.Plugin;

public class WhoMadeTheAppli implements Plugin {

	public WhoMadeTheAppli(){}
	
	@Override
	public String getLabel() {
		return "Tell who made the application";
	}

	@Override
	public String transform(String s) {
		return "This application was made by Kevin GALLET and Charles VANEENOO for the PluginProject in COO";
	}

}
