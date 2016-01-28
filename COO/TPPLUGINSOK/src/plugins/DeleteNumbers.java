package plugins;

import main.Plugin;

public class DeleteNumbers implements Plugin {

	public DeleteNumbers(){}
	
	@Override
	public String getLabel() {
		return "Delete the numbers of your text";
	}

	@Override
	public String transform(String s) {
		int i,j;
		boolean esttrouve = false;
		String monmot = "";
		String number = "1234567890";
		for(i=0; i < s.length();i++){

			System.out.print(" mon i:"+i);

			for(j=0;j< number.length();j++){
				esttrouve = true;
			}
			if(esttrouve == false){
				char malettre = s.charAt(i);
				String malettreenstring = Character.toString(malettre);
				monmot.concat(malettreenstring);
			}
			esttrouve = false;
		}
		return monmot;	
		//return s.replace(s,"");
	}

}
