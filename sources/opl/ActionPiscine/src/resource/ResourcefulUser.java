package resource;

/**
 * 
 * @author Decottignies - Morlet
 *
 * @param <R> a resource
 */
public class ResourcefulUser <R extends Resource>{
	protected R resource;
	
	/**
	 * get the resource
	 * @return the resource
	 */
	public R getResource(){
		return resource;
	}
	
	/**
	 * set the resource
	 * @param resource to set
	 */
	public void setResource(R resource){
		this.resource = resource;
	}
	
	/**
	 * set the resource to null
	 */
	public void resetResource(){
		this.resource = null;
	}
}
