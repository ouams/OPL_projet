package action.resource;

import java.util.NoSuchElementException;

import action.Action;
import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;

/**
 * Take a resource
 * @author Decottignies - Morlet
 *
 * @param <T> a Resource
 */
public class TakeResourceAction <T extends Resource> extends Action{
	
	protected boolean isReady = true;
	protected boolean isFinished = false;
	protected ResourcePool<T> resourcePool;
	protected ResourcefulUser<T> resourcefulUser;


	/**
	 * create a TakeResourceAction
	 * @param resourcePool a resource from the pool
	 * @param resourcefulUser an user from the pool
	 */
	public TakeResourceAction(ResourcePool<T> resourcePool, 
			ResourcefulUser<T> resourcefulUser) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;
	}
	
	/**
	 * get the resource
	 * @return the resource from the pool
	 */
	public ResourcePool<T> getResourcePool(){
		return resourcePool;
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
	 * tell if the action is finished
	 * @return true if is finished else false
	 */
	@Override
	public boolean isFinished() {
		return isFinished;
	}

	
	/**
	 * an user try to take a resource
	 */
	@Override
	public void doStep() {
		try {
			T res = resourcePool.provideResource();
			resourcefulUser.setResource(res);
			isReady = false;
			System.out.println("success");
		}
		catch(NoSuchElementException e){
			System.out.println("failed");
		}
	}
}
