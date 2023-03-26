package module_4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
/*
 * URL: http://demo.automationtesting.in/Register.html
➢ Capture the title of the page.
➢ Capture the current URL.
➢ Check First Name & Last Name text boxes presence and enabled or not.
➢ Select gender male/female then check the status selected or not.
➢ Close browser.
 */
public class Module_4_Hands_on_Practice {
	public WebDriver driver;
  @Test
  public void test1() {
	  driver.navigate().to("https://demo.automationtesting.in/Register.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  String pageTitle = driver.getTitle();
	  System.out.println("Page title is: " + pageTitle);
	  
	  String pageURL = driver.getCurrentUrl();
	  System.out.println("Page URL is: " + pageURL);
	  
	  WebElement firstName = driver.findElement(By.xpath("//*[@id=\'basicBootstrapForm\']/div[1]/div[1]/input"));
	  boolean firstNameStatus = firstName.isDisplayed();
	  System.out.println("Is first name field displayed?: " + firstNameStatus);
	  firstNameStatus = firstName.isEnabled();
	  System.out.println("Is first name field enabled?: " + firstNameStatus);
	  
	  WebElement lastName = driver.findElement(By.xpath("//*[@id=\'basicBootstrapForm\']/div[1]/div[2]/input"));
	  boolean lastNameStatus = lastName.isDisplayed();
	  System.out.println("Is last name field displayed?: " + lastNameStatus);
	  lastNameStatus = lastName.isEnabled();
	  System.out.println("Is last name field enabled?: " + lastNameStatus);
	  
	  WebElement genderMale = driver.findElement(By.xpath("//*[@id=\'basicBootstrapForm\']/div[5]/div/label[1]/input"));
	  WebElement genderFemale = driver.findElement(By.xpath("//*[@id=\'basicBootstrapForm\']/div[5]/div/label[2]/input"));
	  boolean genderMaleStatus = genderMale.isSelected();
	  boolean genderFemaleStatus = genderFemale.isSelected();
	  System.out.println("Is gender male radio button selected?: " + genderMaleStatus);
	  System.out.println("Is gender female radio button selected?: " + genderFemaleStatus);
	  genderMale.click();
	  genderMaleStatus = genderMale.isSelected();
	  System.out.println("Is gender male radio button selected now?: " + genderMaleStatus);
	  genderFemale.click();
	  genderFemaleStatus = genderFemale.isSelected();
	  System.out.println("Is gender female radio button selected now?: " + genderFemaleStatus);
  }
  @BeforeTest
  public void setProperty() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\HOME\\Desktop\\web_browser_resources\\edge\\msedgedriver.exe");
      driver = new EdgeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
