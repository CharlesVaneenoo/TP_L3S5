package plugins;

import main.Plugin;

public class DeleteVowels implements Plugin {

	public DeleteVowels(){}
	
	@Override
	public String getLabel() {
		return "Delete voyel(s) in your text";
	}

	@Override
	public String transform(String s) {
			return s.replace("[aeiouyAEIOUY]","");
	}

}
