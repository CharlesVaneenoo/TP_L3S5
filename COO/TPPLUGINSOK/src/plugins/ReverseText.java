package plugins;

import main.Plugin;

public class ReverseText implements Plugin {

	public ReverseText(){}
	
	@Override
	public String getLabel() {
		return "Reverse text";
	}

	@Override
	public String transform(String s) {
		String finalReversedString = "";
		int sizeS = s.length();
			for(int i = sizeS-1;i >=0; i--){
				finalReversedString += s.charAt(i);
			}
		return finalReversedString;
	}
}
