package pool.test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import pool.Basketpool;
import pool.CubiclePool;
import pool.ResourcePool;
import resource.Basket;
import resource.Cubicle;
import resource.Resource;

public class PoolTest {
	
	protected ResourcePool<Basket> resource1;
	protected ResourcePool<Cubicle> resource2;
	protected ResourcePool<Resource> resource3;
	
	@Before
	public void init(){
		resource1 = new Basketpool(5);
		resource2 = new CubiclePool(1);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void providetest() {
		Cubicle tmp = resource2.provideResource();
		Cubicle tmp2 = resource2.provideResource();		
	}


	@Test(expected = IllegalArgumentException.class)
	public void freetest() {
		Basket tmp = resource1.provideResource();
		resource1.freeResource(tmp);
		Basket tmp2 = new Basket();
		resource1.freeResource(tmp2);
	}

}
