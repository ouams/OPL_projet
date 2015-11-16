package action.scheduler;

import java.util.ArrayList;
import java.util.Iterator;

import action.Action;

/**
 * A scheduler which is execute all doStep of the first action then 
 * execute all doStep of the second action 
 * until the scheduler is finished
 * @author Decottignies - Morlet
 *
 */
public class SequentialScheduler extends Scheduler{

	protected Iterator<Action> it;
	
	/**
	 * create a SequentialScheduler
	 */
	public SequentialScheduler() {
		this.actions=new ArrayList<Action>();
	}
	
	/**
	 * execute one doStep of an action
	 */
	@Override
	public void doStep() {
		if (!isFinished()){
			it = actions.iterator();
			Action ac = nextAction();
			if (ac != null)
				if (!ac.isFinished()){
					ac.doStep();
					isReady = false;
					if (ac.isFinished())
						actions.remove(ac);
				}
		}
	}

	/**
	 * in sequential scheduler the next action is the first action
	 * of the scheduler's list
	 * @return the next action to execute
	 */
	@Override
	public Action nextAction() {
		return it.next();
	}

}
