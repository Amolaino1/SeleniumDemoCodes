package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class SwitchingBrowserTabs {
	WebDriver driver;
  @Test
  public void browserTabs() throws InterruptedException {
		String baseurl = "https://www.tvo.org";
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Get Window Handle
		String MainWindowHandle = driver.getWindowHandle();
		System.out.println("MainWindow Handle is:  " + MainWindowHandle);
		//find Donate element
		WebElement element = driver.findElement(By.xpath("//body[1]/div[1]/header[1]/div[1]/div[1]/ul[1]/li[6]/a[1]/div[1]/span[1]/div[1]"));
		//click on Donate element
		element.click();
		//get all window handles and save in Set
		Set<String> AllWindowhandles = driver.getWindowHandles();
		for (String handle : AllWindowhandles) {
			//print all window handle IDs
			System.out.println(handle);
			if (!handle.equals(MainWindowHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(3000);
				//click on Next button
				driver.findElement(By.xpath("//*[@id=\'pstep_next\']")).click();
				Thread.sleep(5000);
				break;
			}
		}
		//switch back to main window
		driver.switchTo().window(MainWindowHandle);
		//click on remind me later
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/a[2]/span[1]")).click();
		Thread.sleep(3000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
