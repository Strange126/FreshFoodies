import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodTest {
	private Food f1;
	private Food f2;
	@BeforeEach
	void setUp() throws Exception {
		f1 = new Food(1,"Aglio e Olio", 12, "Garlic and Oil with rigatoni", "img");
		f2 = new Food(2,"MacSpicy", 8.5, "Spicy Burger", "img2");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetFood_id() {
		int tester = f1.getFood_id();
		
		assertEquals(tester , 1);
		
		tester = f2.getFood_id();
		
		assertEquals(tester, 2);
	}

	@Test
	void testSetFood_id() {
		int tester = f1.getFood_id();
		
		assertEquals(tester, 1);
		
		f1.setFood_id(41);
		tester = f1.getFood_id();
		
		assertEquals(tester, 41);
	}

	@Test
	void testGetName() {
		String tester = f1.getName();
		
		assertEquals(tester , "Aglio e Olio");
		
		tester = f2.getName();
		
		assertEquals(tester , "MacSpicy");
	}

	@Test
	void testSetName() {
		String tester = f1.getName();
		
		assertEquals(tester , "Aglio e Olio");
		
		f1.setName("Paella");
		tester = f1.getName();
		
		assertEquals(tester , "Paella");
	}

	@Test
	void testGetPrice() {
		double tester = f1.getPrice();
		
		assertEquals(tester , 12);
		
		tester = f2.getPrice();
		
		assertEquals(tester , 8.5);
	}

	@Test
	void testSetPrice() {
		double tester = f1.getPrice();
		
		assertEquals(tester , 12);
		
		f1.setPrice(4.1);
		tester = f1.getPrice();
		
		assertEquals(tester , 4.1);
	}

	@Test
	void testGetDescription() {
		String tester = f1.getDescription();
		
		assertEquals(tester , "Garlic and Oil with rigatoni");
		
		tester = f2.getDescription();
		
		assertEquals(tester , "Spicy Burger");
	}

	@Test
	void testSetDescription() {
		String tester = f1.getDescription();
		
		assertEquals(tester , "Garlic and Oil with rigatoni");
	
		f1.setDescription("Great and Amazing food");
		tester = f1.getDescription();
		assertEquals(tester , "Great and Amazing food");
	}

	@Test
	void testGetImg() {
		String tester = f1.getImg();
		
		assertEquals(tester , "img");
		
		tester = f2.getImg();
		
		assertEquals(tester , "img2");
	}

	@Test
	void testSetImg() {
		String tester = f1.getImg();
		
		assertEquals(tester , "img");
		
		f1.setImg("img23");
		tester = f1.getImg();
		
		assertEquals(tester , "img23");
	}

}
