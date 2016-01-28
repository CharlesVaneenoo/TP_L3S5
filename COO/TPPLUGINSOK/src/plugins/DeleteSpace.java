package plugins;

import main.Plugin;

public class DeleteSpace implements Plugin {

	public DeleteSpace(){}
	
	@Override
	public String getLabel() {
		return "Delete the space in your text";
	}

	@Override
	public String transform(String s) {
		return s.replace(" ","");
	}

}
