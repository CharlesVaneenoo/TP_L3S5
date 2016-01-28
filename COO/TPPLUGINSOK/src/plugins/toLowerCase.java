package plugins;

import main.Plugin;

/**
 * @author Nvk
 */

public class toLowerCase implements Plugin {

	public toLowerCase(){}
	
	@Override
	public String getLabel() {
		return "Transform your text in lower case";
	}

	@Override
	public String transform(String s) {
		return s.toLowerCase();
	}

}
