package actions;

import java.util.*;

public abstract class SchedulerAction extends Action {
	protected boolean isInitialized;
	protected boolean isReady;
	protected List<Action> actions;
	
	/**
	 *  Create a scheduler which is not initialized, but it is ready with a list of actions
	 * 
	 */
	public SchedulerAction(){
		this.isInitialized = false;
		this.isReady = false;
		this.actions = new ArrayList<Action>();
	}

	/**
	 * Return the list of actions of the scheduler
	 * @return the list of actions of the scheduler
	 */
	public List<Action> getList(){
		return actions;
	}
	
	/**
	 * Add the action a to the list of actions, and initialize the Scheduler
	 * @param a
	 * 			The action a which need to be add at the list
	 */
	public void addAction(Action a) {
		this.isInitialized = true;
		this.actions.add(a);
	} 		

	/**
	 * Return true if the scheduler is ready, else return false
	 * 
	 * @return true if the scheduler is ready, else return false
	 */
	@Override
	public boolean isReady() {
		return this.isInitialized() && this.isReady;
	}

	/**
	 * Return true if the scheduler is initialized, else return false
	 * 
	 * @return true if the scheduler is initialized, else return false
	 */
	public boolean isInitialized(){
		return this.isInitialized;
	}
	
	/**
	 * Return true if the scheduler is finished, else return false
	 * 
	 * @return true if the scheduler is finished, else return false
	 */
	public boolean isFinished(){
		return !this.isReady() && this.isInitialized() && this.actions.isEmpty();
	}
	
	/**
	 * The scheduler action will execute all the actions present in the list
	 * @throws ActionFinishedException 
	 * 						if the action is finished
	 * @throws EmptyListException
	 * 						if the list of action is empty
	 */
	@Override
	public void doStep() throws EmptyListException, ActionFinishedException{
				super.doStep();
				this.isReady = false;
	}

}
