package module_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Listener_Demo {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
		driver=new EdgeDriver();
	}
	@Test(priority=1)
	public void validateHomePageTitle() {
		driver.get("http://zero.webappsecurity.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Zero - Personal Banking - Loans - Credit Cards", driver.getTitle());
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("signin_button")).click();
		System.out.println(driver.getTitle());
		System.out.println("This is a new change");
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		System.out.println(driver.getTitle());
		String actual=driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=account-summary.html']")).getText();
		Assert.assertEquals("Account Summary", actual);
		}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}

