package pool;

import java.util.NoSuchElementException;
import actions.EmptyListException;

public class TakeResourceAction<R extends Resource> extends ResourceAction<R>{

	/**
	 * Contructor of the class TakeResourceAction
	 * @param pool the pool used
	 * @param user the user used
	 */
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	/**
	 * Do a step for the action
	 */
	@Override
	protected void step() throws EmptyListException {
		System.out.printf("%s is trying to take resource from %s ...",this.user.nameOfUser,this.pool.toString()); 
		try{
			this.user.setResource(this.pool.provideResource());
			System.out.println("success");
			this.isFinished = true;
			this.isReady = false;
		}catch(NoSuchElementException e){
			System.out.println("failed");
		}
	}

}
