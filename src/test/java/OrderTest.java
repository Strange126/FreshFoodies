import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
	private Order o1;
	private Order o2;

	@BeforeEach
	void setUp() throws Exception {
		o1 = new Order(1, 1, 1, "Pasir ris", 12, "done");
		o2 = new Order(2, 2, 2, "somewhere", 13, "cooking");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetOrder_id() {
		int tester = o1.getOrder_id();
		
		assertEquals(tester, 1);
		
		tester = o2.getOrder_id();
		
		assertEquals(tester, 2);
	}

	@Test
	void testSetOrder_id() {
		int tester = o1.getOrder_id();
		
		assertEquals(tester, 1);
		
		o1.setOrder_id(32);
		tester = o1.getOrder_id();
		
		assertEquals(tester, 32);
	}

	@Test
	void testGetOrder_user_id() {
		int tester = o1.getOrder_user_id();
		
		assertEquals(tester, 1);
		
		tester = o2.getOrder_user_id();
		
		assertEquals(tester, 2);
	}

	@Test
	void testSetOrder_user_id() {
		int tester = o1.getOrder_user_id();
		
		assertEquals(tester, 1);
		
		o1.setOrder_user_id(32);
		tester = o1.getOrder_user_id();
		
		assertEquals(tester, 32);
	}

	@Test
	void testGetOrder_food_id() {
		int tester = o1.getOrder_food_id();
		
		assertEquals(tester, 1);
		
		tester = o2.getOrder_food_id();
		
		assertEquals(tester, 2);
	}

	@Test
	void testSetOrder_food_id() {
		int tester = o1.getOrder_food_id();
		
		assertEquals(tester, 1);
		
		o1.setOrder_food_id(32);
		tester = o1.getOrder_food_id();
		
		assertEquals(tester, 32);
	}

	@Test
	void testGetAddress() {
		String tester = o1.getAddress();
		
		assertEquals(tester , "Pasir ris");
		
		tester = o2.getAddress();
		
		assertEquals(tester , "somewhere");
	}

	@Test
	void testSetAddress() {
		String tester = o1.getAddress();
		
		assertEquals(tester , "Pasir ris");
		
		o1.setAddress("Jacob");
		tester = o1.getAddress();
		
		assertEquals(tester , "Jacob");
	}

	@Test
	void testGetTimestamp() {
		int tester = o1.getTimestamp();
		
		assertEquals(tester, 12);
		
		tester = o2.getTimestamp();
		
		assertEquals(tester, 13);
	}

	@Test
	void testSetTimestamp() {
		int tester = o1.getTimestamp();
		
		assertEquals(tester, 12);
		
		o1.setTimestamp(32);
		tester = o1.getTimestamp();
		
		assertEquals(tester, 32);
	}

	@Test
	void testGetStatus() {
		String tester = o1.getStatus();
		
		assertEquals(tester , "done");
		
		tester = o2.getStatus();
		
		assertEquals(tester , "cooking");
	}

	@Test
	void testSetStatus() {
		String tester = o1.getStatus();
		
		assertEquals(tester , "done");
		
		o1.setStatus("complete!");
		tester = o1.getStatus();
		
		assertEquals(tester , "complete!");
	}

}
