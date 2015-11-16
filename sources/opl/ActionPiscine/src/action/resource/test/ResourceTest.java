package action.resource.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pool.Basketpool;
import pool.ResourcePool;
import resource.Basket;
import resource.ResourcefulUser;

import action.resource.FreeResourceAction;
import action.resource.TakeResourceAction;

public class ResourceTest {

	protected FreeResourceAction fr;
	protected TakeResourceAction tr;
	Basketpool rp = new Basketpool(1);
	ResourcefulUser<Basket> user;
	
	@Before
	public void init(){
		fr = new FreeResourceAction(rp, user);
		tr = new TakeResourceAction(rp, user);
	}
	
	@Test
	public void test() {
		assertFalse(fr.isFinished());
		assertTrue(fr.isReady());
		assertFalse(tr.isFinished());
		assertTrue(tr.isReady());
		assertNotNull(tr.getResourcePool());
	}

}
