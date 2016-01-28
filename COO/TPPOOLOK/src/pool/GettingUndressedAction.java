package pool;

import actions.ActionFinishedException;
import actions.EmptyListException;
import actions.ForeseeableAction;

public class GettingUndressedAction extends ForeseeableAction{

	/**
	 * Create an GettingUndressedAction with a remaining time 
	 * @param timeToEnd the time needed for the action
	 */
	public GettingUndressedAction(int timeToEnd) {
		super(timeToEnd);
	}

	/**
	 * Do one step for the action
	 */
	public void doStep() throws EmptyListException, ActionFinishedException{
		System.out.printf("undressing (%d/%d)\n",this.getTotalTime() - this.getRemainingTime() + 1,this.getTotalTime());
		super.step();
	}
	
}