package action.swimmer.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pool.Basketpool;
import pool.CubiclePool;

import action.swimmer.Swimmer;

public class SwimmerTest {

	protected Swimmer s;
	protected Swimmer s1;
	protected Basketpool b;
	protected CubiclePool c;
	
	@Before
	public void init(){
		b = new Basketpool(1);
		c = new CubiclePool(1);
		s = new Swimmer("Leo", b, c, 2, 2, 2);
		s1 = new Swimmer("Leo1", b, c, 2, 2, 2);
	}
	
	@Test
	public void gettersTest() {
		assertEquals("Leo", s.getName());
		assertEquals(b, s.getBasketPool());
		assertEquals(c,  s.getCubiclePool());
		assertTrue(s.isReady());
		assertFalse(s.isFinished());
	}
	
	@Test
	public void doStepTest(){
		while (!s1.isFinished()){
			s.doStep();
			s1.doStep();
		}
		assertFalse(s.isReady());
		assertTrue(s.isFinished());		
	}

}
