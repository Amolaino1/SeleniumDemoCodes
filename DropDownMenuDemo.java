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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DropDownMenuDemo {
	WebDriver driver;
  @Test
  public void dropDownMenu() throws InterruptedException {
	  driver.navigate().to("https://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement skill = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'Skills\']")));
	  JavascriptExecutor scroll = (JavascriptExecutor) driver;
	  scroll.executeScript("arguments[0].scrollIntoView();", skill );
	  Select dropDown = new Select(skill);
	  dropDown.selectByVisibleText("Certifications");
	  Thread.sleep(4000);
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
