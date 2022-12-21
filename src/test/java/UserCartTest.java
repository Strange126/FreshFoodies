import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserCartTest {
	private UserCart c1;
	private UserCart c2;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new UserCart(1, 1, "Aglio e Olio", 12, "Garlic and Oil with rigatoni");
		c2 = new UserCart(2, 2, "MacSpicy", 8.5, "Spicy Burger");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCart_id() {
		int tester = c1.getCart_id();
		
		assertEquals(tester, 1);
		
		tester = c2.getCart_id();
		
		assertEquals(tester, 2);
	}

	@Test
	void testSetCart_id() {
		int tester = c1.getCart_id();
		
		assertEquals(tester, 1);
		
		c1.setCart_id(21);
		tester = c1.getCart_id();
		
		assertEquals(tester, 21);
	}

	@Test
	void testGetFood_id() {
		int tester = c1.getFood_id();
		
		assertEquals(tester , 1);
		
		tester = c2.getFood_id();
		
		assertEquals(tester, 2);
	}

	@Test
	void testSetFood_id() {
		int tester = c1.getFood_id();
		
		assertEquals(tester, 1);
		
		c1.setFood_id(41);
		tester = c1.getFood_id();
		
		assertEquals(tester, 41);
	}

	@Test
	void testGetName() {
		String tester = c1.getName();
		
		assertEquals(tester , "Aglio e Olio");
		
		tester = c2.getName();
		
		assertEquals(tester , "MacSpicy");
	}

	@Test
	void testSetName() {
		String tester = c1.getName();
		
		assertEquals(tester , "Aglio e Olio");
		
		c1.setName("Spaghetti");
		tester = c1.getName();
		
		assertEquals(tester , "Spaghetti");
	}

	@Test
	void testGetPrice() {
		double tester = c1.getPrice();
		
		assertEquals(tester , 12);
		
		tester = c2.getPrice();
		
		assertEquals(tester , 8.5);
	}

	@Test
	void testSetPrice() {
		double tester = c1.getPrice();
		
		assertEquals(tester , 12);
		
		c1.setPrice(4.1);
		tester = c1.getPrice();
		
		assertEquals(tester , 4.1);	
	}

	@Test
	void testGetDescription() {
		String tester = c1.getDescription();
		
		assertEquals(tester , "Garlic and Oil with rigatoni");
		
		tester = c2.getDescription();
		
		assertEquals(tester , "Spicy Burger");
	}

	@Test
	void testSetDescription() {
		String tester = c1.getDescription();
		
		assertEquals(tester , "Garlic and Oil with rigatoni");
	
		c1.setDescription("Great and Amazing food");
		tester = c1.getDescription();
		assertEquals(tester , "Great and Amazing food");
	}

}
