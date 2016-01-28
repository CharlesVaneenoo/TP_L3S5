/**
 * 
 */
package plugins;

import main.Plugin;

/**
 * @author Nvk
 *
 */
public class toUpperCase implements Plugin {

	public toUpperCase(){}
	
	@Override
	public String getLabel() {
		return "Transform your text in upper case";
	}

	@Override
	public String transform(String s) {
		return s.toUpperCase();
	}
}
