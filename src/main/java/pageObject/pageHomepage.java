package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageHomepage {

	WebDriver driver;
	By searchBox = By.name("query");
	
	public pageHomepage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getsearchBox()
	{
		return driver.findElement(searchBox);
	}
	
	

}
