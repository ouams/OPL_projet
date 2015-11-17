package pool;

import resource.Basket;
/**
 * A basket pool
 * @author Decottignies - Morlet
 *
 */
public class Basketpool extends ResourcePool<Basket>{

	/**
	 * create a Basket pool 
	 * @param nbResources the number of basket available 
	 */
	public Basketpool(int nbResources) {
		super(nbResources);
	}
	
	/**
	 * create a new Basket
	 */
	@Override
	protected Basket create() {
		return new Basket();
	}
	
}
