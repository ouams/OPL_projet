package action;

/**
 * An action
 * @author Decottignies - Morlet
 *
 */
public abstract class Action {
	
	/**
	 * tell if the action is ready
	 * @return true if the action is ready else false
	 */
	public abstract boolean isReady();
	
	/**
	 * tell if the action is finished
	 * @return true if is finished else false
	 */
	public abstract boolean isFinished();
	
	/**
	 * tell if the action is started 
	 * @return true if the action is in progress else false
	 */
	public boolean isInProgress(){
		return !isFinished() && isReady();
	}
	
	/**
	 * execute one step of the action
	 */
	public abstract void doStep();	
}
