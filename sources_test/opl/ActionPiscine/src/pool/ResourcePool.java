package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import resource.Resource;

/**
 * A Resource Pool
 * @author Decottignies - Morlet
 *
 * @param <T> a Resource
 */
public abstract class ResourcePool <T extends Resource>{
	
	protected int nbResources;
	protected List<T> resources;
	protected List<T> usedResources = new ArrayList<T>();
	
	/**
	 * create a ResourcePool
	 * @param nbResources the number of resource available
	 */
	public ResourcePool(int nbResources){
		this.nbResources = nbResources;
		this.resources = new ArrayList<T>();
		for (int i = 0; i < nbResources; i++)
			this.resources.add(create());
	}
	
	/**
	 * create a T
	 * @return a T resource
	 */
	protected abstract T create();
	
	public T provideResource(){
		if (!resources.isEmpty()){
			T tmp = resources.get(0);
			usedResources.add(tmp);
			resources.remove(0);
			return tmp;
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * free the resource
	 * @param resource the resource to free
	 */
	public void freeResource(T resource){
		if (usedResources.contains(resource)){
			resources.add(resource);
			usedResources.remove(resource);
		}
		else
			throw new IllegalArgumentException();
	}
}
