package plugins;

import main.Plugin;

public class DeleteCharacters implements Plugin{

	public DeleteCharacters(){}
	
	@Override
	public String getLabel() {
		return "Delete characters in your text";
	}

	@Override
	public String transform(String s) {
		int i, j;
		boolean bool = false;
		String mot = "";
		char lettre;
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

		for (i=0 ; i < s.length();i++){
			//System.out.println("i ="+i);
			for(j=0;j< alphabet.length();j++){
				//System.out.println("j ="+j);

				if (s.charAt(i) == alphabet.charAt(j)){
					//System.out.println("coucou1");
					bool=true;
				}
			}
			
			if (bool == false){
				System.out.println("coucou2");
				lettre = s.charAt(i);
				String monmot = Character.toString(lettre);
				mot = mot+monmot;
				System.out.println(mot);
				}
				
				bool =false;
			
			
		}
		//return s.replace(alphabet,"");
		return mot;
		//TODO : gerer les accents etc...
	}

}
