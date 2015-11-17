package action.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import action.Action;
import action.ForeseeableAction;

public class ActionTest {

	protected Action a;
	protected ForeseeableAction fa;
	
	@Before
	public void init(){
		fa = new ForeseeableAction(10);
	}
	
	@Test
	public void test() {
		assertEquals(10, fa.getRemainingTime());
		assertEquals(10, fa.getTotalTime());
		assertTrue(fa.isReady());
		assertTrue(fa.isInProgress());
		while (!fa.isFinished())
			fa.doStep();
		assertFalse(fa.isReady());
		assertFalse(fa.isInProgress());
	}

}
