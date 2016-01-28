package pool;

public class BasketPool extends ResourcePool<Basket>{
	
	/**
	 * Constructor for the creation of the pool Basket
	 * @param numberResources the number of resources
	 */
	public BasketPool(int numberResources){
		super(numberResources);
	}

	/**
	 * Create a Resource of Basket type
	 */
	@Override
	protected Basket create() {
		return new Basket();
	}

	/**
	 * Return "pool basket"
	 */
	@Override
	public String toString() {
		return "pool basket";
	}
	
}
