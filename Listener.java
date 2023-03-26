package module_4;
  
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;  
import org.testng.ITestListener;  
import org.testng.ITestResult;  
public class Listener implements ITestListener   
{  
public void onTestStart(ITestResult result) {  
// TODO Auto-generated method stub  
}  
  
public void onTestSuccess(ITestResult result) {  
// TODO Auto-generated method stub  
}  
  
public void onTestFailure(ITestResult result) {  
// TODO Auto-generated method stub  
	//String fileName = "automation_" + getRandomString(4) +".png";	
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("C:\\Users\\HOME\\Desktop\\screenshot\\screenshots.jpg"));
	//FileUtils.copyFile(scrFile, new File("C:\\Users\\HOME\\Desktop\\screenshot\\" + fileName));
	
}  
  
public void onTestSkipped(ITestResult result) {  
// TODO Auto-generated method stub   
}  
  
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
// TODO Auto-generated method stub   
}  
  
public void onStart(ITestContext context) {  
// TODO Auto-generated method stub  
}  
  
public void onFinish(ITestContext context) {  
// TODO Auto-generated method stub  
}  
}  