package selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseClass;

public class TestCase extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(TestCase.class.getName());
	@BeforeTest
	public void initialization() throws IOException
	{
		driver=initializeDriver();
	}

	
  @Test(dataProvider="getdata")
  public void f(String username,String pass) throws IOException {
	 driver.get(prop.getProperty("URL"));
	 LandingPage lo = new LandingPage(driver);
	 lo.getLogin().click();
	 LoginPage lg = new LoginPage(driver);
	 lg.getEmail().sendKeys(username);
	 lg.getPassword().sendKeys(pass);
	 lg.getLogin().click();
	 log.info("Successfully done");
  }
  
  @DataProvider
  public Object[][] getdata()
  {
	  Object[][] data = new Object[2][2];
	  data[0][0] = "thriveni@gmail.com";
	  data[0][1] = "123";
	  data[1][0] = "thriveni@gmail.com";
	  data[1][1] = "thriv4526";
	  return data;
	  
  }
  
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
