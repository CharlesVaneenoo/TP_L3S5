package actions;

/**
 * Throw the message "You try to execute an action whereas the actions list is empty" is an action is finished.
 * 
 * @author Nvk
 */
public class EmptyListException extends Exception {
	
	private static final long serialVersionUID = 5963748382959882498L;

	public EmptyListException(){
		 System.out.println("You try to execute an action whereas the actions list is empty.\n");
	}

}
