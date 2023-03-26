package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

//Mouse drag and drop
public class DragAndDrop {
	private WebDriver driver;
	private String baseUrl;
  @Test
  public void dragAndDrop() throws InterruptedException {
	  driver.get(baseUrl);
		Thread.sleep(1000);
		WebElement stockholm = driver.findElement(By.id("box2"));
		WebElement sweden = driver.findElement(By.id("box102"));
		
		WebElement copenhagen = driver.findElement(By.id("box4"));
		WebElement denmark = driver.findElement(By.id("box104"));
		
		WebElement madrid = driver.findElement(By.id("box7"));
		WebElement spain = driver.findElement(By.id("box107"));
		
		WebElement oslo = driver.findElement(By.id("box1"));
		WebElement norway = driver.findElement(By.id("box101"));
		
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement italy = driver.findElement(By.id("box106"));
		
		WebElement seoul = driver.findElement(By.id("box5"));
		WebElement s_koria = driver.findElement(By.id("box105"));
		
		WebElement washington = driver.findElement(By.id("box3"));
		WebElement u_state = driver.findElement(By.id("box103"));
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(stockholm).perform();
		Thread.sleep(1000);
		action.moveToElement(sweden).perform();
		Thread.sleep(1000);
		action.release(sweden).perform();
		Thread.sleep(1000);
		
		action.clickAndHold(copenhagen).perform();
		Thread.sleep(1000);
		action.moveToElement(denmark).perform();
		Thread.sleep(1000);
		action.release(denmark).perform();
		Thread.sleep(1000);
		
		action.clickAndHold(madrid).perform();
		Thread.sleep(1000);
		action.moveToElement(spain).perform();
		Thread.sleep(1000);
		action.release(spain).perform();
		Thread.sleep(1000);
		
		action.clickAndHold(oslo).perform();
		Thread.sleep(1000);
		action.moveToElement(norway).perform();
		Thread.sleep(1000);
		action.release(norway).perform();
		Thread.sleep(1000);
		
		action.clickAndHold(rome).perform();
		Thread.sleep(1000);
		action.moveToElement(italy).perform();
		Thread.sleep(1000);
		action.release(italy).perform();
		Thread.sleep(1000);
		
		action.clickAndHold(seoul).perform();
		Thread.sleep(1000);
		action.moveToElement(s_koria).perform();
		Thread.sleep(1000);
		action.release(s_koria).perform();
		Thread.sleep(1000);
		
		action.clickAndHold(washington).perform();
		Thread.sleep(1000);
		action.moveToElement(u_state).perform();
		Thread.sleep(1000);
		action.release(u_state).perform();
		Thread.sleep(1000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  baseUrl = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";	
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
