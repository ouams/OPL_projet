package action;

/**
 * A foreseeable action is an action with a time of execution
 * @author Decottignies - Morlet 
 *
 */
public class ForeseeableAction extends Action {

	protected int remainingTime;
	protected int totalTime;
	
	/**
	 * create a foreseeable action with the number of doStep to do
	 * @param timeToEnd the number of doStep of the foreseeable action
	 */
	public ForeseeableAction(int timeToEnd){
		this.totalTime=timeToEnd;
		this.remainingTime=timeToEnd;
	}
	
	/**
	 * get the time remaining until the end of the foreseeable action
	 * @return the remaining time
	 */
	public int getRemainingTime(){
		return remainingTime;
	}
	
	/**
	 * get the total time of the action
	 * @return the total number of doStep to finish the foreseeable action
	 */
	public int getTotalTime(){
		return totalTime;
	}
	
	/**
	 * tell if the foreseeable action is ready
	 * @return true if the foreseeable action is ready else false
	 */
	@Override
	public boolean isReady() {
		return this.remainingTime==this.totalTime;
	}

	/**
	 * tell if the foreseeable action is finished
	 * @return true if the foreseeable action is finished else false
	 */
	@Override
	public boolean isFinished() {
		return this.remainingTime <=0;
	}

	/**
	 * execute one step of the action
	 */
	@Override
	public void doStep() {
		this.remainingTime--;
	}

}
