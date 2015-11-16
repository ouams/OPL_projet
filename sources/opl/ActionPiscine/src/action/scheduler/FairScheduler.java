package action.scheduler;

import java.util.ArrayList;
import java.util.Iterator;

import action.Action;

/**
 * A scheduler which is execute one doStep of the first action then 
 * execute a doStep of the second action until the last action and 
 * back to the begin for re-do a doStep while the scheduler isn't finished
 * @author Decottignies - Morlet
 *
 */
public class FairScheduler extends Scheduler{

	protected Action currentAction;
	protected Iterator<Action> it;
	
	/**
	 * create a FairScheduler
	 */
	public FairScheduler() {
		actions = new ArrayList<Action>();
	}
	
	/**
	 * execute a step of an action
	 */
	@Override
	public void doStep() {
		if (!isFinished()){
			it = actions.iterator();
			Action last = currentAction;
			currentAction = nextAction();
			if (!currentAction.isFinished()){
				currentAction.doStep();
				isReady = false;	
				if (currentAction.isFinished()){
					actions.remove(currentAction);
					currentAction = last;
				}
			}
		}
	}

	/**
	 * in the fair scheduler the next action to execute is 
	 * the next action in the scheduler's list  
	 * @return the next action to execute
	 */
	@Override
	public Action nextAction() {
		if (currentAction == null)
			return it.next();
		while (!it.next().equals(currentAction) && it.hasNext());
		if (it.hasNext())
			return it.next();
		else {
			it = actions.iterator();
			return it.next();
		}
	}
}
