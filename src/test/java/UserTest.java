import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	private User u1;
	private User u2;

	@BeforeEach
	void setUp() throws Exception {
		u1 = new User(1, "Username", "password");
		u2 = new User(2, "username2", "password2");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUser_id() {
		int tester = u1.getUser_id();

		assertEquals(tester, 1);

		tester = u2.getUser_id();

		assertEquals(tester, 2);
	}

	@Test
	void testSetUser_id() {
		int tester = u1.getUser_id();

		assertEquals(tester, 1);

		u1.setUser_id(41);
		tester = u1.getUser_id();

		assertEquals(tester, 41);
	}

	@Test
	void testGetName() {
		String tester = u1.getName();
		
		assertEquals(tester , "Username");
		
		tester = u2.getName();
		
		assertEquals(tester , "username2");
	}

	@Test
	void testSetName() {
		String tester = u1.getName();
		
		assertEquals(tester , "Username");
		
		u1.setName("Paella");
		tester = u1.getName();
		
		assertEquals(tester , "Paella");
	}

	@Test
	void testGetPassword() {
		String tester = u1.getPassword();
		
		assertEquals(tester , "password");
		
		tester = u2.getPassword();
		
		assertEquals(tester , "password2");
	}

	@Test
	void testSetPassword() {
		String tester = u1.getPassword();
		
		assertEquals(tester , "password");
		
		u1.setPassword("Paella");
		tester = u1.getPassword();
		
		assertEquals(tester , "Paella");
	}

}
