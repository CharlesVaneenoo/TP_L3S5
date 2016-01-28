package plugins;

import main.Plugin;

public class CodeCesar implements Plugin {

	private final static String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";	
	private final static String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private int decal;

	public CodeCesar(int dec){
		this.decal = dec;
	}
	
	public int getDecal() {
		return decal;
	}
	
	@Override
	public String getLabel() {
		return "Cesar's Code "+this.decal;
	}

	@Override
	public String transform(String s) {
		int decal = this.getDecal();
		int i = 0;
		String finalString = "";
		char[] arrayS = s.toCharArray();
		
		while (i < s.length()){
			if (Character.isLowerCase(arrayS[i])){
				finalString += lowerCaseAlphabet.charAt(lowerCaseAlphabet.indexOf(i)+decal);
			}
			else if (Character.isUpperCase(arrayS[i])){
				finalString += upperCaseAlphabet.charAt(upperCaseAlphabet.indexOf(i)+decal);
			}
			i++;
		}
		
		return finalString;			
	}



}
