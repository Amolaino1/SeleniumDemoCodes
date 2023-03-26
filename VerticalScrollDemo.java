package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class VerticalScrollDemo {
	WebDriver driver;
  @Test
  public void scroll() throws InterruptedException {
	  driver.navigate().to("https://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  JavascriptExecutor scroll = (JavascriptExecutor) driver;
	 
	  //scroll by 300 pixel
	  scroll.executeScript("window.scrollBy(0, 300)");
	  Thread.sleep(2000);
	  //scroll back up by 300 pixel
	  scroll.executeScript("window.scrollBy(0, -300)");
	  Thread.sleep(2000);
	  
	  //scroll to bottom of page
	  scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  Thread.sleep(2000);
	  
	  //scroll to element first name
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'basicBootstrapForm\']/div[1]/div[1]/input")));
	  scroll.executeScript("arguments[0].scrollIntoView();", submit );
	  Thread.sleep(2000);

  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
      driver = new EdgeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
