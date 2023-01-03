package selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseClass;

public class AssertionValidation extends BaseClass {
	public WebDriver driver;
	public LandingPage lo;
	public static Logger log = LogManager.getLogger(AssertionValidation.class.getName());
	@BeforeTest
	public void initialization() throws IOException
	{
		 driver=initializeDriver();
		 driver.get(prop.getProperty("URL"));
		 
	}
	
	@Test
	public void getTitle() throws IOException
	{
		 
		 //driver.get("http://www.qaclickacademy.com/");
		
		 lo = new LandingPage(driver);
		 Assert.assertEquals(lo.getTitle().getText(),"FEATURE COURSES");
		Assert.assertTrue(lo.getContact().isDisplayed());
		log.info("got the title");
		//System.out.println(driver.findElement(By.partialLinkText("Contact")).getText());
	}
	@Test
	public void getHeader()
	{
		System.out.println(lo.getHeader().getText());
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
