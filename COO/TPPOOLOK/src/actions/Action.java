package actions;

public abstract class Action {
	
	/**
	 * Return true if the action is ready, else return false
	 * 
	 * @return true if the action is ready, else return false
	 */
	protected abstract boolean isReady();

	/**
	 * Return true if the action is in progress, else return false
	 * 
	 * @return true if the action is in progress, else return false
	 */
	public boolean isInProgress(){
		return !this.isReady() && !this.isFinished();
	}
	
	/**
	 * Return true if the action is finished, else return false
	 * 
	 * @return true if the action is finished, else return false
	 */
	protected abstract boolean isFinished();
	
	/**
	 * do one step for the action selectionned.
	 * @throws ActionFinishedException if the action is finished
	 */
	protected abstract void step() throws EmptyListException, ActionFinishedException;
		
	/**
	 * make a call to step for the differents types of action
	 * 
	 * @throws EmptyListException
	 * 						if the list of actions is empty
	 * @throws ActionFinishedException 
	 * 						if the action is finished
	 */
	protected void doStep() throws EmptyListException, ActionFinishedException{
		if (this.isFinished()) throw new ActionFinishedException(); 
		this.step();
	}
	
	/**
	 * return the remainingTime of the current action
	 * 
	 * @return the remainingTime of the current action
	 */
	public int getRemainingTime(){
		return this.getRemainingTime();
	}

	public int getTotalTime() {
		return this.getTotalTime();
	}
	
}
