package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver ;
	public Properties prop ;

	public WebDriver initializeDriver() throws IOException
	{
		 prop = new Properties();
		String path = System.getProperty("user.dir")+File.separator+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		//String browser = System.getProperty("browser");
		String browser = prop.getProperty("browser");
		//chrome
		if(browser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if(browser.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
//		Typecasting driver to takescreenshot so tht it can
//		able to take screenshot and storing in variable.
		TakesScreenshot ts =(TakesScreenshot) driver; 
		
		//this file is taken by selenium.
		//File is stored in virtual loc by selenium.
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//Copying to our local destination using Fileutils class.
		String dest = System.getProperty("user.dir")+".\\resources\\"+testCaseName+".png";
		
		//In the latest version of selenium ,FIleutils class is in another package
		//U need to add dependency of Apache common IO jar
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}
	
	
	
}
