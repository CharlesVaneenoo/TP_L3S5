package pool;

import actions.ActionFinishedException;
import actions.EmptyListException;
import actions.ForeseeableAction;

public class GettingDressedAction extends ForeseeableAction {

	/**
	 * Create an GettingDressedAction with a remaining time 
	 * @param timeToEnd the time needed for the action
	 */
	public GettingDressedAction(int timeToEnd) {
		super(timeToEnd);
	}
	
	/**
	 * Do one step for the action
	 */
	public void doStep() throws EmptyListException, ActionFinishedException{
		System.out.printf("dressing (%d/%d)\n",this.getTotalTime() - this.getRemainingTime() + 1,this.getTotalTime());
		super.step();
	}
	
	
}
