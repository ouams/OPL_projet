package resource.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import resource.Basket;
import resource.Cubicle;
import resource.Resource;
import resource.ResourcefulUser;

public class ResourceTest {

	protected Basket basket;
	protected Cubicle cubicle;
	protected ResourcefulUser<Resource> user;
	
	@Before
	public void init(){
		basket = new Basket();
		cubicle = new Cubicle();
		user = new ResourcefulUser<Resource>();
	}
	
	@Test
	public void test() {
		assertEquals("Basket", basket.description());
		assertEquals("Cubicle", cubicle.description());
		user.setResource(basket);
		assertEquals(basket, user.getResource());
		user.resetResource();
		assertNull(user.getResource());
	}

}
