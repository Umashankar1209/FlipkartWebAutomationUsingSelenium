package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;

import pageObjects.FlipkartMainPageObjects;
import pageObjects.RoutersPageObjects;
import pageObjects.TVPageObjects;

public class TestCasesForFlipkart {
	org.apache.log4j.Logger logger;
	public static String  FlipkartUrl="https://www.flipkart.com/";
	WebDriver driver;
	Actions actions;
	Select select;
	File tempFile;
	File destFile;
	@Test(priority = 1)
	public void lapTopOrder() throws IOException
	{
		logger=org.apache.log4j.Logger.getLogger("Log4jExample");
		DOMConfigurator.configure("log4j.xml");
         driver = new ChromeDriver();
         driver.get(FlipkartUrl);
         logger.info("Broser Opening");
         driver.manage().window().maximize();
         PageFactory.initElements(driver, RoutersPageObjects.class);
         PageFactory.initElements(driver, FlipkartMainPageObjects.class);
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         FlipkartMainPageObjects.Electronics.click();
         logger.info("clicking electronics page");
         RoutersPageObjects.ElectronicsAudio.click();
         logger.info("clicking Audio button");
         actions= new Actions(driver).moveToElement(RoutersPageObjects.Routers);
         RoutersPageObjects.Routers.click();
         logger.info("clicking router button");
         actions= new Actions(driver).moveToElement(RoutersPageObjects.DLinkRouter);
         RoutersPageObjects.DLinkRouter.click();
         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
         String parentWindow =driver.getWindowHandle();
         for(String childwindow:driver.getWindowHandles())
         {
        	 if(!(childwindow == parentWindow))
             {
        		 driver.switchTo().window(childwindow);
             }
          }
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
 		 {
 	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pincodeInputId']")));
 		 }
         driver.findElement(By.xpath("//*[@id='pincodeInputId']")).click();
         driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("632316");
         driver.findElement(By.xpath("//span[@class='i40dM4']")).click();
         logger.info("Checking order location");
         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); 		 
         wait.until(ExpectedConditions.elementToBeClickable(RoutersPageObjects.BuyNowButton));	 
         RoutersPageObjects.BuyNowButton.click();
         logger.info("clicking bu now button");
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Login or Signup']")));
		 File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(tempFile, new File("D:\\Job\\FlipkartProjectSS\\LapTopOrder.jpg"));
         logger.info("taking screenshot");
         driver.quit();
         
         
         
	}
	@Test(priority = 2)
	public void autoSuggestions() throws InterruptedException, IOException
	{
		logger=org.apache.log4j.Logger.getLogger("Log4jExample");
		DOMConfigurator.configure("log4j.xml");
		driver = new ChromeDriver();
	    PageFactory.initElements(driver, FlipkartMainPageObjects.class);
	    PageFactory.initElements(driver, TVPageObjects.class);
		driver.get(FlipkartUrl);
		 logger.info("Broser Opening");
        driver.manage().window().maximize();
		FlipkartMainPageObjects.searchBox.sendKeys("TV");
		logger.info("Searching TV in searchBox");
		Thread.sleep(2000);
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 {
	       wait.until(ExpectedConditions.visibilityOfAllElements(FlipkartMainPageObjects.autoSuggestion));
		 }
		List<WebElement> suggestions=FlipkartMainPageObjects.autoSuggestion;
		logger.info("suggestions displays");
		for(WebElement suggestion : suggestions)
		{
			String TVlistValues = suggestion.getText();
			//System.out.println(TVlistValues);
			if(TVlistValues.contains("tv 32"))
			{
				suggestion.click();
				logger.info("selecting TV 32");
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		TVPageObjects.samsungTV.click();
		logger.info("Selecting samsung TV");
		String parentWindow =driver.getWindowHandle();
		for(String childwindow:driver.getWindowHandles())
        {
       	 if(!(childwindow == parentWindow))
            {
       		 driver.switchTo().window(childwindow);
            }
        }
 	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pincodeInputId']")));
		driver.findElement(By.xpath("//*[@id='pincodeInputId']")).click();
        driver.findElement(By.xpath("//*[@id='pincodeInputId']")).sendKeys("632316"); 
        driver.findElement(By.xpath("//span[@class='i40dM4']")).click();
        logger.info("Checking order location");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); 
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
 		 {
 	       wait2.until(ExpectedConditions.elementToBeClickable(TVPageObjects.BuyNowButton));
 		 }
        TVPageObjects.BuyNowButton.click();
        logger.info("clicking bu now button");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Login or Signup']")));
        File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tempFile, new File("D:\\Job\\FlipkartProjectSS\\AutoSuggestions.jpg"));
        logger.info("taking screenshot");
        driver.quit();
} 
}       
        
        
         
         
         
         
    	 
	

