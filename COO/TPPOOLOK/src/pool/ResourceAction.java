package pool;

import actions.Action;

public abstract class ResourceAction <R extends Resource> extends Action {
	protected ResourcePool<R> pool;
	protected ResourcefulUser<R> user;
	protected boolean isReady;
	protected boolean isFinished;
	
	/**
	 * Constructor of the class Resource Action to manage the resource action
	 * @param pool
	 * @param user
	 */
	public ResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user){
		super();
		this.user = user;
		this.pool = pool;
		this.isReady = true;
		this.isFinished = false;
	}
	
	
	/**
	 * Return true if the current ResourceAction is ready, else return false
	 * @return true if the current ResourceAction is ready, else return false
	 */
	public boolean isReady(){
		return this.isReady;
	}
	
	/**
	 * Return true if the current ResourceAction is finished, else return false
	 * @return true if the current ResourceAction is finished,else return false
	 */
	public boolean isFinished(){
		return this.isFinished;
	}
}
