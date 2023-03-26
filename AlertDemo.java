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
import org.testng.annotations.AfterTest;

public class AlertDemo {
	WebDriver driver;
  @Test
  public void demoOnAlert() throws InterruptedException {
	  driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //alert with OK
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'OKTab\']/button"))).click();
	  Thread.sleep(3000);
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
	  
	  //alert with cancel
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'CancelTab\']/button"))).click();
	  Thread.sleep(3000);
	  driver.switchTo().alert().dismiss();
	  
	  //alert with test box
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a"))).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'Textbox\']/button"))).click();
	  //Thread.sleep(2000);
	  driver.switchTo().alert().sendKeys("Kenneth Etuk");
	  Thread.sleep(3000);
	  alert.accept();
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
