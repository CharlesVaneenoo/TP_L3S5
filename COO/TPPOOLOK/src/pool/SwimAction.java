package pool;

import actions.ActionFinishedException;
import actions.EmptyListException;
import actions.ForeseeableAction;

public class SwimAction extends ForeseeableAction {

	/**
	 * Create an SwimAction with a remaining time 
	 * @param timeToEnd the time needed for the action
	 */
	public SwimAction(int timeToEnd) {
		super(timeToEnd);
	}

	/**
	 * Do one step for the action
	 */
	public void doStep() throws EmptyListException, ActionFinishedException{
		System.out.printf("swiming (%d/%d)\n",(this.getTotalTime()-this.getRemainingTime() +1),this.getTotalTime());
		super.step();
	}

}
