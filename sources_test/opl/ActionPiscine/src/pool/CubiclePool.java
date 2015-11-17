package pool;

import resource.Cubicle;

/**
 * A cubicle pool
 * @author Decottignies - Morlet
 *
 */
public class CubiclePool extends ResourcePool<Cubicle>{

	/**
	 * create a Cubicle Pool 
	 * @param nbResources the number of cubicle available
	 */
	public CubiclePool(int nbResources) {
		super(nbResources);
	}

	/**
	 * create a Cubicle
	 * @return a cubicle
	 */
	@Override
	protected Cubicle create() {
		return new Cubicle();
	}
}
