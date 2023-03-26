package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class MouseHover {
	WebDriver driver;
	private String baseUrl;
  @Test
  public void mouseHover() throws InterruptedException {
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  Actions action = new Actions(driver);
	  WebElement main_item_2 = driver.findElement(By.xpath("//*[@id=\'nav\']/li[2]/a"));
	  WebElement sub_list = driver.findElement(By.xpath("//*[@id=\'nav\']/li[2]/ul/li[3]/a"));
	  
	  //mouse hover
	  action.moveToElement(main_item_2).perform();
	  Thread.sleep(2000);
	  action.moveToElement(sub_list).perform();
	  Thread.sleep(2000);
	  
	  WebElement main_item_1 = driver.findElement(By.xpath("//*[@id=\'nav\']/li[1]/a"));
	  
	  //mouse right-click 
	  action.contextClick(main_item_1).perform();
	  Thread.sleep(2000);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  baseUrl = "https://demoqa.com/menu/";	
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
