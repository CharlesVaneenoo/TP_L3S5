package pool;

import actions.EmptyListException;

public class FreeResourceAction<R extends Resource> extends ResourceAction<R>{

	/**
	 * Contructor of the class FreeResourceAction
	 * @param pool the pool used
	 * @param user the user used
	 */
	public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	/**
	 * Do one step for the Action
	 */
	@Override
	protected void step() throws EmptyListException {
		try{
			this.pool.freeResource(this.user.getResource());
			this.user.resetResource();
			this.isFinished = true;
			this.isReady = false;
			System.out.println(this.user + " freeing resource from " 
								+ this.pool.toString());
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}		
	}


}
