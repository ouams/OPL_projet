package action.swimmer;

import action.Action;
import action.ForeseeableAction;
import action.resource.FreeResourceAction;
import action.resource.TakeResourceAction;
import pool.Basketpool;
import pool.CubiclePool;
import pool.ResourcePool;
import resource.Resource;
import resource.ResourcefulUser;

/**
 * A swimmer
 * @author Decottignies - Morlet
 *
 */
public class Swimmer extends Action {
	protected String name;
	protected ResourcePool basketPool;
	protected ResourcePool cubiclePool;
	protected ResourcefulUser<Resource> rBasket;
	protected ResourcefulUser<Resource> rCubicle;
	protected ForeseeableAction undressing;
	protected ForeseeableAction swimming;
	protected ForeseeableAction dressing;
	protected TakeResourceAction<Resource> traBasket;
	protected TakeResourceAction<Resource> traCubicle;
	protected FreeResourceAction<Resource> fraBasket;
	protected FreeResourceAction<Resource> fraCubicle;
	
	
	/**
	 * create a swimmer
	 * @param name the name of the swimmer
	 * @param basketPool basket from the pool
	 * @param cubiclePool cubicle from the pool
	 * @param undressingTime time to get undressed
	 * @param swimmingTime time for swimming
	 * @param dressingTime time to get dressed
	 */
	public Swimmer(String name, Basketpool basketPool, CubiclePool cubiclePool, int undressingTime, int swimmingTime, int dressingTime){
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		rBasket = new ResourcefulUser<Resource>();
		rCubicle = new ResourcefulUser<Resource>();
		undressing = new ForeseeableAction(undressingTime);
		swimming = new ForeseeableAction(swimmingTime);
		dressing = new ForeseeableAction(dressingTime);
		traBasket = new TakeResourceAction<Resource>((ResourcePool)basketPool, rBasket);
		traCubicle = new TakeResourceAction<Resource>((ResourcePool)cubiclePool, rCubicle);
		fraBasket = new FreeResourceAction<Resource>((ResourcePool)basketPool, rBasket);
		fraCubicle = new FreeResourceAction<Resource>((ResourcePool)cubiclePool, rCubicle);
	}
	
	/**
	 * get the swimmer's name
	 * @return the name of the swimmer
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * get the basket
	 * @return yhe basket pool
	 */
	public Basketpool getBasketPool(){
		return (Basketpool) basketPool;
	}
	
	/**
	 * get the cubicle
	 * @return the cubicle pool
	 */
	public CubiclePool getCubiclePool(){
		return (CubiclePool) cubiclePool;
	}
	
	/**
	 * tell if the swimmer is ready
	 * @return true if the swimmer is ready else false
	 */
	@Override
	public boolean isReady() {
		return !isFinished();
	}

	/**
	 * tell if the swimmer has finished
	 * @return true if finished else false
	 */
	@Override
	public boolean isFinished() {
		return undressing.isFinished() && swimming.isFinished() && dressing.isFinished() 
				&& rBasket.getResource() == null && rCubicle.getResource() == null;
	}

	/**
	 * do a step of the swimmer schedule
	 */
	@Override
	public void doStep() {
		System.out.println(getName()+"'s turn");
		if (rBasket.getResource() == null){
			System.out.print(getName()+" trying to take resource from pool basket... ");
			traBasket.doStep();
		}
		else if (!undressing.isFinished()){
			if (rCubicle.getResource() == null){
				System.out.print(getName()+" trying to take resource from pool cubicle... ");
				traCubicle.doStep();			
			}
			else {
				undressing.doStep();
				System.out.println("undressing "+(undressing.getTotalTime()-undressing.getRemainingTime())+"/"+undressing.getTotalTime());
			}
		}
		else if (rCubicle.getResource() != null && !swimming.isFinished()){
			System.out.println(getName()+" freeing resource pool cubicle");
			fraCubicle.doStep();		
		}
		else if (!swimming.isFinished()){
			swimming.doStep();
			System.out.println("swimming "+(swimming.getTotalTime()-swimming.getRemainingTime())+"/"+swimming.getTotalTime());			
		}
		else if (rCubicle.getResource() == null && !dressing.isFinished()){
			System.out.print(getName()+" trying to take resource from pool cubicle... ");
			traCubicle.doStep();			
		}
		else if (!dressing.isFinished()){
			dressing.doStep();
			System.out.println("dressing "+(dressing.getTotalTime()-dressing.getRemainingTime())+"/"+dressing.getTotalTime());			
		}
		else if (rCubicle.getResource() != null && dressing.isFinished()){
			System.out.println(getName()+" freeing resource pool cubicle");
			fraCubicle.doStep();		
		}
		else{
			System.out.println(getName()+" freeing resource pool basket");
			fraBasket.doStep();					
		}
	}
}
