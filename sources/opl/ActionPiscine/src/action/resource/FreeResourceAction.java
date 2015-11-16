package action.resource;

import action.Action;
import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;

/**
 * Free a resource
 * @author Decottignies - Morlet
 *
 * @param <T> a Resource
 */
public class FreeResourceAction <T extends Resource> extends Action{

	protected boolean isReady = true;
	protected boolean isFinished = false;
	protected ResourcePool<T> resourcePool;
	protected ResourcefulUser<T> resourcefulUser;
	
	/**
	 * create the FreeResourceAction with an user and a resource
	 * @param resourcePool a resource from the pool
	 * @param resourcefulUser an user from the pool
	 */
	public FreeResourceAction(ResourcePool<T> resourcePool,
			ResourcefulUser<T> resourcefulUser) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;	
	}
	
	/**
	* tell if the action is ready
	* @return true if the action is ready else false
	*/
	@Override
	public boolean isReady() {
		return isReady;
	}

	/**
	* tell if the action is ready
	* @return true if the action is ready else false
	*/
	@Override
	public boolean isFinished() {
		return isFinished;
	}

	/**
	 * an user freeing a resource
	 * @exception IllegalArgumentException if the user have no resource
	 */
	@Override
	public void doStep() {
		try {
			resourcePool.freeResource(resourcefulUser.getResource());
			resourcefulUser.resetResource();
			isReady = true;
		}
		catch(IllegalArgumentException e){
		}
	}
}
