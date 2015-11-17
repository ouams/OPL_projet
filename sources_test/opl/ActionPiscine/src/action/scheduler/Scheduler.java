package action.scheduler;

import java.util.Collection;

import action.Action;

/**
 * A scheduler
 * @author Decottignies - Morlet
 *
 */
public abstract class Scheduler extends Action{

	protected boolean isReady=true;
	protected boolean isInitialized=false;
	protected Collection<Action> actions;
	
	/**
	 * tell if the scheduler is ready
	 * @return true if the scheduler is ready else false
	 */
	@Override
	public boolean isReady() {
		return isInitialized && isReady;
	}

	/**
	* tell if the scheduler is finished
	* @return true if is scheduler is finished else false
	*/
	@Override
	public boolean isFinished() {
		return isInitialized && !isReady() && actions.isEmpty();
	}

	/**
	 * execute an action in the scheduler the order depends of the 
	 * scheduler type
	 */
	public abstract void doStep();
	
	/**
	 * obtain the next action to execute
	 * @return the next action in the scheduler
	 */
	public abstract Action nextAction();

	/**
	 * add an action in the scheduler
	 * @param a the action to add in the scheduler
	 */
	public void addAction(Action a){
		actions.add(a);
		isInitialized = true;
	}
}
