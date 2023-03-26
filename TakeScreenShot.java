package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class TakeScreenShot {
	 WebDriver driver;
  @Test
  public void screenShot() throws IOException {
	  driver.get("http://www.facebook.com");
		
		String fileName = "automation_" + getRandomString(4) +".png";	
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\HOME\\Desktop\\screenshot\\screenshots1.jpg"));
		FileUtils.copyFile(scrFile, new File("C:\\Users\\HOME\\Desktop\\screenshot\\" + fileName));
		
		  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
      driver.close();
  }
  
  public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
}

}
