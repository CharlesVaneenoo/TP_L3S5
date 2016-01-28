package actions;

public class ForeseeableAction extends Action {
	
	private final int totalTime; 
	private int remainingTime;
	
	/**
	 * Create a foreseeableAction with the time total the action needs to be finished,
	 * and the remainingTime while action is in progress
	 * 
	 * @param timeToEnd
	 */
	public ForeseeableAction(int timeToEnd){
		this.totalTime = timeToEnd;
		this.remainingTime = timeToEnd;
	}
	
	/**
	 * Return the time total of the action
	 * 
	 * @return the time total of the action
	 */
	public int getTotalTime(){
		return this.totalTime;
	}
	
	/**
	 * Return remaining time of the action
	 * 
	 * @return remaining time of the action
	 */
	public int getRemainingTime(){
		return this.remainingTime;
	}
	
	/**
	 * Return true if the current foresseableAction is ready, else return false
	 * @return true if the current foresseableAction is ready, else return false
	 */
	@Override
	protected boolean isReady() {
		return this.remainingTime == this.totalTime;
	}
	
	/**
	 * Return true if the current foresseableAction is finished, else return false
	 * @return true if the current foresseableAction is finished, else return false
	 */
	@Override
	public boolean isFinished() {
		return this.remainingTime <= 0;
	}

	/**
	 * Decrease the remaining time of the current foreseeableAction.
	 */
	@Override
	protected void step() {
		this.remainingTime--;
	}
}
	
