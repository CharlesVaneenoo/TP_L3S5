package pool;

import actions.Action;
import actions.ActionFinishedException;
import actions.EmptyListException;
import actions.SequentialScheduler;

public class Swimmer extends Action {

	private String name;
	private BasketPool BasketPool;
	private CubiclePool CubiclePool;
	private int timeToUndress;
	private int timeToSwim;
	private int timeToDressBack;
	private ResourcefulUser<Basket> userBasket;
	private ResourcefulUser<Cubicle> userCubicle;
	private SequentialScheduler scheduler;
	
	/**
	 * Constructor for the swimmer class
	 * @param name the name of the swimmer
	 * @param baskets the basket resource pool used
	 * @param cubicles the cubicle resource pool used
	 * @param timeToUndress the time needed for the swimmer to undress
	 * @param timeToSwim the time to swim of the swimmer
	 * @param timeToDressBack the time needed for the swimmer to dress back
	 */
	public Swimmer(String name,BasketPool baskets,CubiclePool cubicles, int timeToUndress, int timeToSwim, int timeToDressBack){
		super();
		this.name=name;
		this.BasketPool = baskets;
		this.CubiclePool = cubicles;
		this.timeToUndress = timeToUndress;
		this.timeToSwim = timeToSwim;
		this.timeToDressBack = timeToDressBack;
		this.scheduler = new SequentialScheduler();
		this.initialiseScheduler();
	}
	
	/**
	 * Initialise the scheduler of the object
	 */
	private void initialiseScheduler(){
		this.userBasket = new ResourcefulUser<Basket>(this.name);
		this.userCubicle = new ResourcefulUser<Cubicle>(this.name);
		this.scheduler.addAction(new TakeResourceAction<Basket>(this.BasketPool, this.userBasket));
		this.scheduler.addAction(new TakeResourceAction<Cubicle>(this.CubiclePool, this.userCubicle));
		this.scheduler.addAction(new GettingUndressedAction(this.timeToUndress));
		this.scheduler.addAction(new FreeResourceAction<Cubicle>(this.CubiclePool, this.userCubicle));
		this.scheduler.addAction(new SwimAction(this.timeToSwim));
		this.scheduler.addAction(new TakeResourceAction<Cubicle>(this.CubiclePool, this.userCubicle));
		this.scheduler.addAction(new GettingDressedAction(this.timeToDressBack));
		this.scheduler.addAction(new FreeResourceAction<Cubicle>(this.CubiclePool, this.userCubicle));
		this.scheduler.addAction(new FreeResourceAction<Basket>(this.BasketPool, this.userBasket));
	}

	/**
	 * Return true if the current SwimmerAction is ready, else return false
	 * @return true if the current SwimmerAction is ready, else return false
	 */
	@Override
	protected boolean isReady() {
		return this.scheduler.isReady();
	}

	/**
	 * Return true if the current SwimmerAction is finished, else return false
	 * @return true if the current SwimmerAction is finished, else return false
	 */
	@Override
	public boolean isFinished() {
		return this.scheduler.isFinished();
	}
	
	/**
	 * Do one step for the current action
	 */
	protected void doStep() throws EmptyListException, ActionFinishedException{
		System.out.println(this.name +"'s turn");
		this.scheduler.doStep();
	}

	/** 
	 * Nothing to do here.
	 */
	@Override
	protected void step() throws EmptyListException, ActionFinishedException {}

	/**
	 * Return name of the swimmer
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the time needed by the swimmer to undress 
	 * @return the timeToUndress
	 */
	public int getTimeToUndress() {
		return timeToUndress;
	}

	/**
 	 * Return the time needed by the swimmer to swim 
	 * @return the timeToSwim
	 */
	public int getTimeToSwim() {
		return timeToSwim;
	}

	/**
	 * Return the time needed by the swimmer to dress back 
	 * @return the timeToDressBack
	 */
	public int getTimeToDressBack() {
		return timeToDressBack;
	}
	
	/**
	 * Return the scheduler of the swimmer action 
	 * @return the scheduler of the swimmer action 
	 */
	public SequentialScheduler getScheduler() {
		return scheduler;
	}
}

