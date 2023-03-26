package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Flight_Date_Demo {
	WebDriver driver;
  @Test
  public void demoOnAlert() throws InterruptedException {
	  driver.navigate().to("https://www.nanakflights.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String title = driver.getTitle();
	  System.out.println(title);
	  
	  //alert with OK
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DepDate"))).clear();
	  Thread.sleep(2000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DepDate"))).sendKeys("09/01/2023");
	  Thread.sleep(3000);
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ArrDate"))).clear();
	  Thread.sleep(2000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ArrDate"))).sendKeys("10/03/2023");
	  Thread.sleep(3000);
	  Assert.assertEquals(title, "Cheap Flights, Airline Tickets, Travel Agency in Brampton, ON, Canada | NanakFlights");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
      driver = new EdgeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
