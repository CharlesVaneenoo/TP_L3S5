package pool;

public class CubiclePool extends ResourcePool<Cubicle>{

	/**
	 * Constructor for the creation of the pool cubicle
	 * @param numberResources the number of resources
	 */
	public CubiclePool(int nbResources){
		super(nbResources);
	}

	/**
	 * Create a resource cubicle
	 */
	@Override
	protected Cubicle create() {
		return new Cubicle();
	}

	/**
	 * Return "pool cubicle"
	 */
	@Override
	public String toString() {
		return "pool cubicle";
	}
}


