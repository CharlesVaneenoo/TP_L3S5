package actions;


/**
 * Throw the message "Action is finished" is an action is finished.
 * 
 * @author Nvk
 */
public class ActionFinishedException extends Exception {

	private static final long serialVersionUID = 5245367851543889120L;

	public ActionFinishedException(){
		System.out.println("Action is finished.\n");
	}
	
}
