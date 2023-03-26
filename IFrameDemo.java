package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class IFrameDemo {
	WebDriver driver;
  @Test
  public void frame() throws InterruptedException {
	  driver.navigate().to("https://demo.automationtesting.in/Frames.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Switched to frame");
	  Thread.sleep(3000);
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
