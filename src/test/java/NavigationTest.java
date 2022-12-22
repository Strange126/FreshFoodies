import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NavigationTest {
	static private WebDriver webDriver;
	static private String chromeDriverDir;

	@Test
	public void checkTitleOfPages() {
		webDriver.navigate().to("http://localhost:8080/FreshFoodies/FoodServlet");
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Insert title here");
		
		webDriver.findElement(By.linkText("Login")).click();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Login Page");
		webDriver.findElement(By.linkText("Fresh Foodies")).click();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Insert title here");
		
		webDriver.findElement(By.linkText("Login")).click();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Login Page");
		webDriver.findElement(By.linkText("Sign up")).click();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Sign Up Page");
		
		webDriver.findElement(By.linkText("Fresh Foodies")).click();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Insert title here");
		
		webDriver.findElement(By.linkText("Login")).click();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Login Page");
		
		webDriver.findElement(By.name("LoginUsername")).sendKeys("Strange");
		webDriver.findElement(By.name("LoginPassword")).sendKeys("password123");
		webDriver.findElement(By.name("LoginButton")).submit();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Insert title here");
		
		
		webDriver.findElement(By.linkText("View Cart")).click();
		System.out.println(webDriver.getCurrentUrl());
		assertEquals(webDriver.getTitle(), "Viewing Cart");
	}
	
	

	@AfterAll
	static public void afterTest() {
		webDriver.quit();	
	}

	@BeforeAll
	static public void beforeTest() {
		chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		webDriver = new ChromeDriver();
	}

}
