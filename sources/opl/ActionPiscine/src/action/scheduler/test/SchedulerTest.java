package action.scheduler.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pool.Basketpool;
import pool.CubiclePool;

import action.scheduler.FairScheduler;
import action.scheduler.Scheduler;
import action.scheduler.SequentialScheduler;
import action.swimmer.Swimmer;

public class SchedulerTest {

	protected Scheduler sch;
	protected FairScheduler fsch;
	protected SequentialScheduler ssch;
	protected Swimmer s;
	protected Swimmer s1;
	protected Swimmer s2;
	protected Swimmer s3;
	protected Basketpool b;
	protected CubiclePool c;
	protected Basketpool b1;
	protected CubiclePool c1;
	
	@Before
	public void init(){
		fsch = new FairScheduler();
		ssch = new SequentialScheduler();
		b = new Basketpool(1);
		c = new CubiclePool(1);
		s = new Swimmer("Leo", b, c, 2, 2, 2);
		s1 = new Swimmer("Leo1", b, c, 2, 2, 2);
		s2 = new Swimmer("Leo", b, c, 2, 2, 2);
		s3 = new Swimmer("Leo1", b, c, 2, 2, 2);
	}
	
	@Test
	public void test() {
		fsch.addAction(s);
		fsch.addAction(s1);
		ssch.addAction(s2);
		ssch.addAction(s3);
		while (!fsch.isFinished())
			fsch.doStep();
		while (!ssch.isFinished())
			ssch.doStep();
	}

}
